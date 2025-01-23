package user_service.user_service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import user_service.user_service.service.UserService;

@SpringBootApplication
@EnableRabbit
public class UserServiceApplication implements CommandLineRunner {
	private final ApplicationContext applicationContext;

	public UserServiceApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// Chỉ khởi động gRPC server khi không chạy dưới môi trường Maven build
		if (!isRunningInBuildMode()) {
			UserService userService = applicationContext.getBean(UserService.class);
			Server server = ServerBuilder.forPort(50050)
					.addService(userService)
					.build()
					.start();

			System.out.println("gRPC Server started on port 50050...");

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
