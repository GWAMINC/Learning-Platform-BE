package APIGateWay.APIGateWay.controller;

import com.example.gatewayuser.GateWayUserRpcProto;
import com.example.gatewayuser.UserServiceGrpc;
import com.example.gatewayuser.GateWayUserRpcProto.*;
import com.google.protobuf.util.JsonFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/user")
public class UserServiceController {

    private final ManagedChannel userServiceChannel;
    private final UserServiceGrpc.UserServiceBlockingStub userServiceStub;

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
    @PreDestroy
    public void shutdown() {
        // Đóng kết nối khi ứng dụng dừng
        userServiceChannel.shutdown();
    }
}
