package user_service.user_service.service;

import com.example.gatewayuser.GateWayUserRpcProto;
import com.example.gatewayuser.UserServiceGrpc;
import com.example.gatewayuser.GateWayUserRpcProto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user_service.user_service.repository.UserRepository;
import user_service.user_service.utils.JwtUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    private LoggingService loggingService;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
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
