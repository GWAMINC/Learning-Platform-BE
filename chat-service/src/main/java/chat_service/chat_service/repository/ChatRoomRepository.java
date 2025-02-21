package chat_service.chat_service.repository;

import chat_service.chat_service.model.ChatRoom;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends MongoRepository<ChatRoom, String> {

    // Lấy danh sách chatroom của user
    @Query("{ 'participants': ?0 }")
    List<ChatRoom> findByUserId(String userId);

    // Kiểm tra xem đã có chatroom giữa user1 và user2 chưa
    @Query("{ 'participants': { $all: [?0, ?1] } }")
    Optional<ChatRoom> findByParticipants(String user1, String user2);
}
