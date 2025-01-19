package user_service.user_service.controller;

import com.example.common.MessageOuterClass;
import com.example.usercourse.UserCourseRpcProto;
import com.example.usercourse.UserCourseServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/api/user/hello")
    public String helloUser() {
        return "Hello, User!";
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/api/user/send")
    public String sendMessage(@RequestBody String content) {
        try {
            // Tạo message bằng Protobuf
            MessageOuterClass.Message message = MessageOuterClass.Message.newBuilder()
                    .setContent(content)
                    .build();

            // Sử dụng phương thức toByteArray() để mã hóa message thành byte array
            byte[] messageBytes = message.toByteArray();

            // Gửi message qua RabbitMQ
            rabbitTemplate.convertAndSend("courseExchange", "courseRoutingKey", messageBytes);

            return "Message sent to Course Service!";
        } catch (Exception e) {
            e.printStackTrace(); // In ra chi tiết lỗi
            return "Failed to send message: " + e.getMessage();
        }
    }
    @GetMapping("/api/user/course-info")
    public String getCourseInfo(@RequestParam String courseId) {
        // Kết nối tới gRPC server của CourseService
        ManagedChannel channel = ManagedChannelBuilder.forAddress("course-service", 50051)
                .usePlaintext()
                .build();

        try {
            // Tạo client gRPC
            UserCourseServiceGrpc.UserCourseServiceBlockingStub stub =
                    UserCourseServiceGrpc.newBlockingStub(channel);

            // Tạo request
            UserCourseRpcProto.GetCourseRequest request = UserCourseRpcProto.GetCourseRequest.newBuilder()
                    .setCourseId(courseId)
                    .build();

            // Gửi request và nhận response
            UserCourseRpcProto.GetCourseResponse response = stub.getCourseInfo(request);

            return "Course Info: " + response.getCourseName();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to fetch course info: " + e.getMessage();
        } finally {
            // Đóng kết nối
            channel.shutdown();
        }
    }
}
