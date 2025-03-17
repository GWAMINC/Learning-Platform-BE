package user_service.user_service.service;

import com.cloudinary.Cloudinary;
import com.example.common.MessageOuterClass;
import com.example.gatewaycourse.CourseServiceGrpc;
import com.example.gatewaycourse.GateWayCourseRpcProto;
import com.example.gatewayuser.GateWayUserRpcProto;
import com.example.gatewayuser.UserServiceGrpc;
import com.example.gatewayuser.GateWayUserRpcProto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import user_service.user_service.repository.UserRepository;
import user_service.user_service.utils.JwtUtil;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static user_service.user_service.utils.RandomPassword.generatePassword;

@Service
public class UserService extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final CourseServiceGrpc.CourseServiceBlockingStub courseServiceBlockingStub;
    private final Cloudinary cloudinary;
    @Autowired
    private LoggingService loggingService;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public UserService(UserRepository userRepository, JwtUtil jwtUtil, Cloudinary cloudinary) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.cloudinary = cloudinary;
        ManagedChannel channel = ManagedChannelBuilder.forAddress("course-service", 50051)
                .usePlaintext()
                .build();
        this.courseServiceBlockingStub = CourseServiceGrpc.newBlockingStub(channel);
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
    public void updateUser(updateUserRequest request, StreamObserver<updateUserResponse> responseObserver) {
        try {
            // Kiểm tra user có tồn tại không
            Map<String, Object> user = userRepository.findUserById(request.getId());
            if (user.isEmpty()) {
                responseObserver.onNext(updateUserResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("User not found")
                        .build());
                responseObserver.onCompleted();
                return;
            }

            // Kiểm tra password có hợp lệ không
            if (request.getPassword() != null && !isValidPassword(request.getPassword())) {
                updateUserResponse response = updateUserResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, and a number")
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            // Cập nhật thông tin user
            userRepository.updateUser(
                    request.getId(),
                    request.getUsername(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getRole()
            );

            updateUserResponse response = updateUserResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("User updated successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            updateUserResponse response = updateUserResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Internal server error: " + e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
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
                String username = (String) user.get("username");
                String token = jwtUtil.generateToken((String) user.get("email"), userId, (String) user.get("role"));

                LoginResponse response = LoginResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Login successful")
                        .setToken(token)
                        .setUsername(username)
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

    @Override
    public void getUserBio(GateWayUserRpcProto.getUserBioRequest request, StreamObserver<GateWayUserRpcProto.getUserBioResponse> responseObserver) {
        Map<String, Object> bioData = userRepository.getBio(request.getId());
        GateWayCourseRpcProto.GetViewEnrollCourseRequest request1 = GateWayCourseRpcProto.GetViewEnrollCourseRequest.newBuilder()
                .setId(request.getId())
                .build();
        GateWayCourseRpcProto.GetViewEnrollCourseResponse response1 = courseServiceBlockingStub.viewEnrollCourse(request1);
        GateWayUserRpcProto.Bio.Builder bioBuilder = GateWayUserRpcProto.Bio.newBuilder();
        if (bioData != null) {
            bioBuilder.setId((int) bioData.get("id"))
                    .setUserId((int) bioData.get("user_id"))
                    .setFirstName((String) bioData.get("first_name"))
                    .setLastName((String) bioData.get("last_name"))
                    .setAddress((String) bioData.get("address"))
                    .setPhone((String) bioData.get("phone"))
                    .setGender((String) bioData.get("gender"))
                    .setBirthDate(bioData.get("birth_date").toString())
                    .setBio((String) bioData.get("bio"))
                    .setAvatar((String) bioData.get("avatar"));
            for (GateWayCourseRpcProto.Course course : response1.getCoursesList()) {
                GateWayUserRpcProto.Course courseProto = GateWayUserRpcProto.Course.newBuilder()
                        .setId(course.getId())
                        .setTitle(course.getTitle())
                        .setDescription(course.getDescription())
                        .setCreatedAt(course.getCreatedAt())
                        .setUpdatedAt(course.getUpdatedAt())
                        .build();
                bioBuilder.addEnrolledCourses(courseProto);

            }
        }

        GateWayUserRpcProto.getUserBioResponse response = GateWayUserRpcProto.getUserBioResponse.newBuilder()
                .setBio(bioBuilder)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateUserBio(GateWayUserRpcProto.updateUserBioRequest request,
                              StreamObserver<GateWayUserRpcProto.updateUserBioResponse> responseObserver) {
        try {
            // 1️⃣ Kiểm tra user có tồn tại không
            Map<String, Object> user = userRepository.findUserById(request.getId());
            if (user.isEmpty()) {
                responseObserver.onNext(GateWayUserRpcProto.updateUserBioResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("User not found")
                        .build());
                responseObserver.onCompleted();
                return;
            }

            // 2️⃣ Kiểm tra giá trị gender hợp lệ
            String gender = request.getGender();
            if (gender == null || (!gender.equals("male") && !gender.equals("female") && !gender.equals("other"))) {
                responseObserver.onNext(GateWayUserRpcProto.updateUserBioResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Invalid gender value. Allowed values: male, female, other.")
                        .build());
                responseObserver.onCompleted();
                return;
            }

            // 3️⃣ Kiểm tra xem user đã có bio chưa
            Map<String, Object> bioData = null;
            try {
                bioData = userRepository.getBio(request.getId());
            } catch (EmptyResultDataAccessException e) {
                // Nếu không có bio thì để null
            }

            // 4️⃣ Upload avatar lên Cloudinary nếu có dữ liệu
            String avatarUrl = (bioData != null) ? (String) bioData.get("avatar") : null;
            byte[] avatarData = request.getAvatar().toByteArray();
            boolean hasAvatar = avatarData.length > 0;

            if (hasAvatar) {
                if (cloudinary == null) {
                    throw new IllegalStateException("Cloudinary is not initialized");
                }

                Map<String, Object> uploadResult = cloudinary.uploader()
                        .upload(avatarData, Map.of("resource_type", "image"));
                avatarUrl = uploadResult.get("url").toString();
            }

            // 5️⃣ Cập nhật hoặc thêm bio vào database
            if (bioData == null) {
                userRepository.addBio(
                        request.getId(),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getAddress(),
                        request.getPhone(),
                        request.getGender(),
                        request.getBirthDate(),
                        request.getBio(),
                        avatarUrl
                );
            } else {
                userRepository.updateBio(
                        request.getId(),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getAddress(),
                        request.getPhone(),
                        request.getGender(),
                        request.getBirthDate(),
                        request.getBio(),
                        avatarUrl
                );
            }

            // 6️⃣ Lấy thông tin bio sau khi cập nhật
            Map<String, Object> updatedBio = userRepository.getBio(request.getId());

            // Kiểm tra kiểu dữ liệu birth_date
            Object birthDateObj = updatedBio.get("birth_date");
            String birthDateStr = (birthDateObj instanceof Date)
                    ? ((Date) birthDateObj).toLocalDate().format(DateTimeFormatter.ISO_DATE)
                    : (birthDateObj != null ? birthDateObj.toString() : "");

            // Lấy danh sách khóa học đã đăng ký
            GateWayCourseRpcProto.GetViewEnrollCourseRequest courseRequest = GateWayCourseRpcProto.GetViewEnrollCourseRequest.newBuilder()
                    .setId(request.getId())
                    .build();
            GateWayCourseRpcProto.GetViewEnrollCourseResponse courseResponse = courseServiceBlockingStub.viewEnrollCourse(courseRequest);

            // 7️⃣ Tạo đối tượng Bio để gửi phản hồi
            GateWayUserRpcProto.Bio.Builder bioBuilder = GateWayUserRpcProto.Bio.newBuilder()
                    .setId((int) updatedBio.get("id"))
                    .setUserId((int) updatedBio.get("user_id"))
                    .setFirstName(updatedBio.get("first_name").toString())
                    .setLastName(updatedBio.get("last_name").toString())
                    .setAddress(updatedBio.get("address").toString())
                    .setPhone(updatedBio.get("phone").toString())
                    .setGender(updatedBio.get("gender").toString())
                    .setBirthDate(birthDateStr)
                    .setBio(updatedBio.get("bio").toString())
                    .setAvatar(avatarUrl != null ? avatarUrl : "");

            // Thêm các khóa học đã đăng ký vào Bio
            for (GateWayCourseRpcProto.Course course : courseResponse.getCoursesList()) {
                GateWayUserRpcProto.Course courseProto = GateWayUserRpcProto.Course.newBuilder()
                        .setId(course.getId())
                        .setTitle(course.getTitle())
                        .setDescription(course.getDescription())
                        .setCreatedAt(course.getCreatedAt())
                        .setUpdatedAt(course.getUpdatedAt())
                        .build();
                bioBuilder.addEnrolledCourses(courseProto);
            }

            // 8️⃣ Trả về response thành công
            responseObserver.onNext(GateWayUserRpcProto.updateUserBioResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Profile updated successfully")
                    .setBio(bioBuilder.build())
                    .build());
            responseObserver.onCompleted();

        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onNext(GateWayUserRpcProto.updateUserBioResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Internal server error: " + e.getMessage())
                    .build());
            responseObserver.onCompleted();
        }
    }
}
