package course_service.course_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoggingService {

    private static final Logger logger = LoggerFactory.getLogger(LoggingService.class);

    public void logCourseActivity(int statusCode, String action, String metadata) {
        logger.info("Course-service | Status: {} | Action: {} | Metadata: {}", statusCode, action, metadata);
    }

    public void logError(Exception e, String action) {
        int statusCode = 500; // Mặc định là 500 Internal Server Error

        // Nếu Exception có chứa mã lỗi HTTP, thì lấy từ đó
        if (e instanceof ResponseStatusException) {
            statusCode = ((ResponseStatusException) e).getStatusCode().value();
        }

        logger.error("Course-service | Status: {} | Action: {} | Error: {}", statusCode, action, e.getMessage());
    }

}
