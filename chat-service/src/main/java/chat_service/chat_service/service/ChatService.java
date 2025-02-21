package chat_service.chat_service.service;

import chat_service.chat_service.model.ChatMessage;
import chat_service.chat_service.model.ChatRoom;
import chat_service.chat_service.repository.ChatMessageRepository;
import chat_service.chat_service.repository.ChatRoomRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public ChatService(ChatMessageRepository chatMessageRepository, ChatRoomRepository chatRoomRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.chatRoomRepository = chatRoomRepository;
    }

    // Lấy danh sách chatroom của user
    public List<ChatRoom> getUserChatRooms(String userId) {
        return chatRoomRepository.findByUserId(userId);
    }

    // Tạo hoặc lấy chatroom giữa 2 người dùng
    public ChatRoom createOrGetChatRoom(String user1, String user2) {
        Optional<ChatRoom> existingRoom = chatRoomRepository.findByParticipants(user1, user2);
        return existingRoom.orElseGet(() -> {
            ChatRoom newRoom = new ChatRoom(List.of(user1, user2));
            return chatRoomRepository.save(newRoom);
        });
    }

    // Lấy tin nhắn cũ theo chatRoomId (sắp xếp mới nhất -> cũ nhất)
    public List<ChatMessage> getChatMessages(String chatRoomId) {
        return chatMessageRepository.findByChatRoomIdOrderByTimestampDesc(chatRoomId, Sort.by(Sort.Direction.DESC, "timestamp"));
    }
}
