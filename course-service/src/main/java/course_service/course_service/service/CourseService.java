package course_service.course_service.service;

import com.example.common.MessageOuterClass;
import com.example.usercourse.UserCourseRpcProto;
import com.example.usercourse.UserCourseServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends UserCourseServiceGrpc.UserCourseServiceImplBase {

    @RabbitListener(queues = "courseQueue")
    public void receiveMessage(byte[] messageBody) {
        try {
            // Giải mã message từ byte array bằng Protobuf
            MessageOuterClass.Message message = MessageOuterClass.Message.parseFrom(messageBody);
            System.out.println("Received message: " + message.getContent());
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to process message: " + e.getMessage());
        }
    }
    @Override
    public void getCourseInfo(UserCourseRpcProto.GetCourseRequest request, StreamObserver<UserCourseRpcProto.GetCourseResponse> responseObserver) {
        String courseId = request.getCourseId();

        // Tìm thông tin khoá học (ví dụ: lấy từ database hoặc service khác)
        String courseName = "Example Course Name for " + courseId;

        // Tạo response
        UserCourseRpcProto.GetCourseResponse response = UserCourseRpcProto.GetCourseResponse.newBuilder()
                .setCourseName(courseName)
                .build();

        // Gửi response về cho client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
