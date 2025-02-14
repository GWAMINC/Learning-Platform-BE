package user_service.user_service.service;

import com.example.common.MessageOuterClass;
import com.example.gatewayuser.GateWayUserRpcProto;
import com.example.gatewayuser.UserServiceGrpc;
import com.example.gatewayuser.GateWayUserRpcProto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_service.user_service.repository.UserRepository;
import user_service.user_service.utils.JwtUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static user_service.user_service.utils.RandomPassword.generatePassword;

@Service
public class UserService extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    private LoggingService loggingService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }
    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        return Pattern.matches(passwordPattern, password);
    }

    @Override
    public void getUser(GateWayUserRpcProto.GetUserRequest request, StreamObserver<GateWayUserRpcProto.GetUserResponse> responseObserver) {
        // Lấy dữ liệu từ database
        Map<String, Object> result = userRepository.findUserById(request.getId());
        if (result == null || result.isEmpty()) {
            responseObserver.onError(new RuntimeException("User not found"));
            loggingService.logError(new RuntimeException("User not found"), "getUser");
            return;
        }

        // Map dữ liệu vào Protobuf từ Map<String, Object>
        GateWayUserRpcProto.User user = GateWayUserRpcProto.User.newBuilder()
                .setId((Integer) result.get("id"))
                .setUsername((String) result.get("username"))
                .setEmail((String) result.get("email"))
                .setPassword((String) result.get("password"))
                .setRole((String) result.get("role"))
                .setCreatedAt(result.get("created_at").toString())
                .setUpdatedAt(result.get("updated_at").toString())
                .build();

        // Tạo response
        GetUserResponse response = GetUserResponse.newBuilder().setUser(user).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
        loggingService.logUserActivity(200, "getUser", response.toString());
    }

    @Override
    public void getAllUsers(GetAllUsersRequest request, StreamObserver<GetAllUsersResponse> responseObserver) {
        // Lấy danh sách từ database
        List<Map<String, Object>> results = userRepository.findAllUsers();

        // Map danh sách vào Protobuf từ List<Map<String, Object>>
        List<GateWayUserRpcProto.User> users = results.stream().map(row -> GateWayUserRpcProto.User.newBuilder()
                .setId((Integer) row.get("id"))
                .setUsername((String) row.get("username"))
                .setEmail((String) row.get("email"))
                .setPassword((String) row.get("password"))
                .setRole((String) row.get("role"))
                .setCreatedAt(row.get("created_at").toString())
                .setUpdatedAt(row.get("updated_at").toString())
                .build()).toList();

        // Tạo response
        GetAllUsersResponse response = GetAllUsersResponse.newBuilder().addAllUsers(users).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void register(RegisterRequest request, StreamObserver<RegisterResponse> responseObserver) {
        try {
            // Kiểm tra username đã tồn tại chưa
            Optional<Map<String, Object>> userByUsername = userRepository.findByUsername(request.getUsername());
            if (userByUsername.isPresent()) {
                RegisterResponse response = RegisterResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Username already exists")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            // Kiểm tra email đã tồn tại chưa
            Optional<Map<String, Object>> userByEmail = userRepository.findByEmail(request.getEmail());
            if (userByEmail.isPresent()) {
                RegisterResponse response = RegisterResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Email already exists")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            // Kiểm tra password có hợp lệ không
            if (!isValidPassword(request.getPassword())) {
                RegisterResponse response = RegisterResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, and a number")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            // Thêm user mới vào database
            userRepository.addUser(request.getUsername(), request.getEmail(), request.getPassword(), request.getRole());

            RegisterResponse response = RegisterResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User registered successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            RegisterResponse response = RegisterResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Internal server error: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void forgotPassword(ForgotPasswordRequest request, StreamObserver<ForgotPasswordResponse> responseObserver) {
        Optional<Map<String, Object>> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isPresent()) {
            Map<String, Object> user = userOptional.get();
            String email = (String) user.get("email");

            // Tạo mật khẩu ngẫu nhiên
            String newPassword = generatePassword();

            // Cập nhật mật khẩu mới vào database
            userRepository.updatePassword(email, newPassword);

            // Gửi mật khẩu mới qua RabbitMQ
            sendNewPasswordEmail(email, newPassword);

            ForgotPasswordResponse response = ForgotPasswordResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("New password sent to email")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            ForgotPasswordResponse response = ForgotPasswordResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Email not found")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    private void sendNewPasswordEmail(String email, String newPassword) {
        // Tạo message bằng Protobuf
        MessageOuterClass.Message message = MessageOuterClass.Message.newBuilder()
                .setReceiver(email)
                .setContent("Your new password is: " + newPassword)
                .build();

        // Sử dụng phương thức toByteArray() để mã hóa message thành byte array
        byte[] messageBytes = message.toByteArray();

        // Gửi message qua RabbitMQ
        rabbitTemplate.convertAndSend("emailExchange", "emailRoutingKey", messageBytes);
    }

    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        Optional<Map<String, Object>> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isPresent()) {
            Map<String, Object> user = userOptional.get();
            String storedPassword = (String) user.get("password");

            if (storedPassword.equals(request.getPassword())) {
                int userId = (int) user.get("id");
                String token = jwtUtil.generateToken((String) user.get("email"), userId);

                LoginResponse response = LoginResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Login successful")
                        .setToken(token)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }
        }

        LoginResponse response = LoginResponse.newBuilder()
                .setSuccess(false)
                .setMessage("Invalid email or password")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
