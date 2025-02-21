package chat_service.chat_service.repository;

import chat_service.chat_service.model.ChatMessage;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    // Lấy tin nhắn theo chatRoomId, sắp xếp mới nhất -> cũ nhất
    @Query("{ 'chatRoomId': ?0 }")
    List<ChatMessage> findByChatRoomIdOrderByTimestampDesc(String chatRoomId, Sort sort);
}
