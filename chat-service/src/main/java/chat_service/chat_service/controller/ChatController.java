package chat_service.chat_service.controller;

import chat_service.chat_service.model.ChatRoom;
import chat_service.chat_service.model.ChatMessage;
import chat_service.chat_service.service.ChatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    // API lấy danh sách chatroom của user
    @GetMapping("/chatrooms/{userId}")
    public List<ChatRoom> getUserChatRooms(@PathVariable String userId) {
        return chatService.getUserChatRooms(userId);
    }

    // API tạo chatroom mới hoặc lấy chatroom đã tồn tại
    @PostMapping("/chatroom")
    public ChatRoom createOrGetChatRoom(@RequestParam("user1") String user1, @RequestParam("user2") String user2) {
        return chatService.createOrGetChatRoom(user1, user2);
    }

    // API lấy tin nhắn cũ theo chatRoomId (sắp xếp mới nhất -> cũ nhất)
    @GetMapping("/messages/{chatRoomId}")
    public List<ChatMessage> getChatMessages(@PathVariable String chatRoomId) {
        return chatService.getChatMessages(chatRoomId);
    }
}
