package course_service.course_service;

import course_service.course_service.service.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableRabbit
public class CourseServiceApplication implements CommandLineRunner  {
	private final ApplicationContext applicationContext;

	public CourseServiceApplication(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Chỉ khởi động gRPC server khi không chạy dưới môi trường Maven build
		if (!isRunningInBuildMode()) {
			CourseService courseService = applicationContext.getBean(CourseService.class);
			CategoryService categoryService = applicationContext.getBean(CategoryService.class);
			UnitService unitService = applicationContext.getBean(UnitService.class);
			LessonService lessonService = applicationContext.getBean(LessonService.class);
			CourseCategoryService courseCategoryService = applicationContext.getBean(CourseCategoryService.class);
			CouponService couponService = applicationContext.getBean(CouponService.class);
			MediaService mediaService = applicationContext.getBean(MediaService.class);
			Server server = ServerBuilder.forPort(50051)
					.addService(courseService)
					.addService(categoryService)
					.addService(unitService)
					.addService(lessonService)
					.addService(courseCategoryService)
					.addService(couponService)
					.addService(mediaService)
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
