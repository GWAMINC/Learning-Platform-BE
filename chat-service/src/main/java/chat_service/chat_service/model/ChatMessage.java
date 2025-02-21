package chat_service.chat_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "messages")
public class ChatMessage {
    @Id
    private String id;
    private String chatRoomId;
    private String sender;
    private String content;
    private String timestamp;
}
