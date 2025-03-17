package APIGateWay.APIGateWay.controller;

import APIGateWay.APIGateWay.service.LoggingService;
import com.example.gatewayuser.GateWayUserRpcProto;
import com.example.gatewayuser.UserServiceGrpc;
import com.example.gatewayuser.GateWayUserRpcProto.*;
import com.google.protobuf.ByteString;
import com.google.protobuf.util.JsonFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserServiceController {

    private final ManagedChannel userServiceChannel;
    private final UserServiceGrpc.UserServiceBlockingStub userServiceStub;

    @Autowired
    private LoggingService loggingService;

    public UserServiceController() {
        // Kết nối tới user-service qua gRPC
        // Chạy Docker container với tên là "user-service"
        this.userServiceChannel = ManagedChannelBuilder.forAddress("user-service", 50050)
                .usePlaintext()
                .build();
        // Chạy local
//        this.userServiceChannel = ManagedChannelBuilder.forAddress("localhost", 50050)
//                .usePlaintext()
//                .build();
        this.userServiceStub = UserServiceGrpc.newBlockingStub(userServiceChannel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id) {
        try {
            // Gửi request đến user-service qua gRPC
            GetUserRequest request = GetUserRequest.newBuilder()
                    .setId(id)
                    .build();

            GetUserResponse response = userServiceStub.getUser(request);

            loggingService.logAPIActivity(200, "getUserById", response.toString());

            // Chuyển đổi từ protobuf sang JSON
            String json = JsonFormat.printer().includingDefaultValueFields().print(response);

            // Trả về với Content-Type là application/json
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch user\"}");
        }
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody Map<String, Object> requestBody) {
        try {
            GateWayUserRpcProto.updateUserRequest request = GateWayUserRpcProto.updateUserRequest.newBuilder()
                    .setId(id)
                    .setUsername(requestBody.get("username").toString())
                    .setEmail(requestBody.get("email").toString())
                    .setPassword(requestBody.get("password").toString())
                    .setRole(requestBody.get("role").toString())
                    .build();

            // Gửi request đến user-service qua gRPC
            updateUserResponse response = userServiceStub.updateUser(request);

            // Trả về message từ gRPC response
            return ResponseEntity.status(response.getSuccess() ? 200 : 400)
                    .body(Map.of("success", response.getSuccess(), "message", response.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("success", false, "message", "Internal server error"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllUsers() {
        try {
            // Gửi request đến user-service qua gRPC
            GateWayUserRpcProto.GetAllUsersRequest request = GateWayUserRpcProto.GetAllUsersRequest.newBuilder().build();
            GateWayUserRpcProto.GetAllUsersResponse response = userServiceStub.getAllUsers(request);

            // Chuyển đổi từ protobuf sang JSON
            String json = JsonFormat.printer().includingDefaultValueFields().print(response);

            // Trả về với Content-Type là application/json
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch users\"}");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> requestBody) {
        try {
            GateWayUserRpcProto.RegisterRequest registerRequest = GateWayUserRpcProto.RegisterRequest.newBuilder()
                    .setUsername(requestBody.get("username").toString())
                    .setEmail(requestBody.get("email").toString())
                    .setPassword(requestBody.get("password").toString())
                    .setRole(requestBody.get("role").toString())
                    .build();

            // Gọi gRPC để đăng ký người dùng
            GateWayUserRpcProto.RegisterResponse response = userServiceStub.register(registerRequest);

            // Trả về message từ gRPC response
            return ResponseEntity.status(response.getSuccess() ? 200 : 400)
                    .body(Map.of("success", response.getSuccess(), "message", response.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("success", false, "message", "Internal server error"));
        }

    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, Object> requestBody) {
        try {
            GateWayUserRpcProto.ForgotPasswordRequest forgotPasswordRequest = GateWayUserRpcProto.ForgotPasswordRequest.newBuilder()
                    .setEmail(requestBody.get("email").toString())
                    .build();

            // Gọi gRPC để yêu cầu reset mật khẩu
            GateWayUserRpcProto.ForgotPasswordResponse response = userServiceStub.forgotPassword(forgotPasswordRequest);

            // Trả về message từ gRPC response
            return ResponseEntity.status(response.getSuccess() ? 200 : 400)
                    .body(Map.of("success", response.getSuccess(), "message", response.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("success", false, "message", "Internal server error"));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> requestBody) {
        try {
            GateWayUserRpcProto.LoginRequest loginRequest = GateWayUserRpcProto.LoginRequest.newBuilder()
                    .setEmail(requestBody.get("email").toString())
                    .setPassword(requestBody.get("password").toString())
                    .build();

            // Gọi gRPC để xác thực người dùng
            GateWayUserRpcProto.LoginResponse response = userServiceStub.login(loginRequest);

            if (!response.getSuccess()) {
                return ResponseEntity.status(401).body(Map.of("success", false, "message", "Invalid credentials"));
            }

            // Tạo cookie chứa token
            ResponseCookie jwtCookie = ResponseCookie.from("token", response.getToken())
                    .httpOnly(true)
                    .secure(true)
                    .path("/")
                    .sameSite("Strict")
                    .maxAge(Duration.ofDays(1))
                    .build();

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, jwtCookie.toString()) // Set cookie
                    .body(Map.of("success", true, "message", "Login successful", "username", response.getUsername()));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("success", false, "message", "Internal server error"));
        }
    }
    @GetMapping("profile/{id}")
    public ResponseEntity<?> getUserProfile(@PathVariable int id) {
        try {
            GateWayUserRpcProto.getUserBioRequest request = GateWayUserRpcProto.getUserBioRequest.newBuilder()
                    .setId(id)
                    .build();

            // Gọi gRPC để lấy thông tin profile
            GateWayUserRpcProto.getUserBioResponse response = userServiceStub.getUserBio(request);

            String json = JsonFormat.printer().includingDefaultValueFields().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("success", false, "message", "Internal server error"));
        }
    }
    @PostMapping(value = "edit-profile/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<ResponseEntity<?>> updateUserProfile(
            @PathVariable int id,
            @RequestPart("first_name") String firstName,
            @RequestPart("last_name") String lastName,
            @RequestPart("address") String address,
            @RequestPart("phone") String phone,
            @RequestPart("gender") String gender,
            @RequestPart("birth_date") String birthDate,
            @RequestPart("bio") String bio,
            @RequestPart(value = "avatar", required = false) Mono<FilePart> avatar) {

        return avatar
                .flatMap(filePart -> filePart.content().collectList().map(dataBufferList -> {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    dataBufferList.forEach(buffer -> {
                        byte[] bytes = new byte[buffer.readableByteCount()];
                        buffer.read(bytes);
                        try {
                            outputStream.write(bytes);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    return ByteString.copyFrom(outputStream.toByteArray());
                }))
                .defaultIfEmpty(ByteString.EMPTY)
                .map(avatarByteString -> {
                    GateWayUserRpcProto.updateUserBioRequest request = GateWayUserRpcProto.updateUserBioRequest.newBuilder()
                            .setId(id)
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setAddress(address)
                            .setPhone(phone)
                            .setGender(gender)
                            .setBirthDate(birthDate)
                            .setBio(bio)
                            .setAvatar(avatarByteString)
                            .build();

                    GateWayUserRpcProto.updateUserBioResponse response = userServiceStub.updateUserBio(request);

                    // Convert the response to JSON
                    String jsonResponse;
                    try {
                        jsonResponse = JsonFormat.printer().includingDefaultValueFields().print(response);
                    } catch (Exception e) {
                        return ResponseEntity.status(500).body(Map.of("success", false, "message", "Failed to parse response"));
                    }

                    return ResponseEntity.status(response.getSuccess() ? 200 : 400)
                            .header("Content-Type", "application/json")
                            .body(jsonResponse);
                });
    }

    @GetMapping("/protected-endpoint")
    public ResponseEntity<String> testEndpoint(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("🚨 No Authentication found!");
        }
        return ResponseEntity.ok("✅ Authenticated user: " + authentication.getName());
    }

    @PreDestroy
    public void shutdown() {
        // Đóng kết nối khi ứng dụng dừng
        userServiceChannel.shutdown();
    }
}
