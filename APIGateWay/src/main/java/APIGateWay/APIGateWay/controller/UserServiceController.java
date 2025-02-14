package APIGateWay.APIGateWay.controller;

import APIGateWay.APIGateWay.service.LoggingService;
import com.example.gatewayuser.GateWayUserRpcProto;
import com.example.gatewayuser.UserServiceGrpc;
import com.example.gatewayuser.GateWayUserRpcProto.*;
import com.google.protobuf.util.JsonFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.Duration;
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
                    .body(Map.of("success", true, "message", "Login successful"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("success", false, "message", "Internal server error"));
        }
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
