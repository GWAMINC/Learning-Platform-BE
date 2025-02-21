package chat_service.chat_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "chatrooms")
public class ChatRoom {
    @Id
    private String id;
    private List<String> participants;

    public ChatRoom(List<String> participants) {
        this.participants = participants;
    }
}
