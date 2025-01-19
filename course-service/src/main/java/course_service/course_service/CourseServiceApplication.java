package course_service.course_service;

import course_service.course_service.service.CourseService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class CourseServiceApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Chỉ khởi động gRPC server khi không chạy dưới môi trường Maven build
		if (!isRunningInBuildMode()) {
			Server server = ServerBuilder.forPort(50051)
					.addService(new CourseService())
					.build()
					.start();

			System.out.println("gRPC Server started on port 50051...");

			// Giữ server hoạt động
			server.awaitTermination();
		}
	}
	// Kiểm tra xem có đang chạy trong chế độ build Maven không
	private boolean isRunningInBuildMode() {
		String mavenProperty = System.getProperty("maven.build");
		return mavenProperty != null && mavenProperty.equals("true");
	}
}
