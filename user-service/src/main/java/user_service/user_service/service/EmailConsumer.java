package user_service.user_service.service;

import com.example.common.MessageOuterClass;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailConsumer {
    @Autowired
    private JavaMailSender emailSender;

    @RabbitListener(queues = "emailQueue")
    public void receiveMessage(byte[] messageBytes) {
        try {
            // Giải mã message từ byte array
            MessageOuterClass.Message message = MessageOuterClass.Message.parseFrom(messageBytes);

            // Tạo email
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(message.getReceiver());
            email.setSubject("Your New Password");
            email.setText(message.getContent());
            System.out.print("Email sent to: " + message.getReceiver());
            System.out.print("Content sent to: " + message.getContent());
            // Gửi email
            emailSender.send(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
