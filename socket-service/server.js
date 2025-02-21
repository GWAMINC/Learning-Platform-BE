const express = require("express");
const http = require("http");
const socketIo = require("socket.io");
const mongoose = require("mongoose");
const cors = require("cors");
require("dotenv").config();

const Message = require("./model/Message");

const app = express();
const server = http.createServer(app);
const io = socketIo(server, {
    cors: {
        origin: "*",
        methods: ["GET", "POST"]
    }
});

// Kết nối MongoDB
mongoose.connect(process.env.MONGO_URI).then(() => console.log("✅ MongoDB Connected"))
    .catch(err => console.error("❌ MongoDB connection error:", err));

// Middleware CORS
app.use(cors());
app.use(express.json());

// Lắng nghe WebSocket từ client
io.on("connection", (socket) => {
    console.log("🔵 User connected", socket.id);

    socket.on("sendMessage", async ({ chatRoomId, sender, content }) => {
        console.log(`📩 Nhận tin nhắn: ${content} từ ${sender} -> (room: ${chatRoomId})`);

        // Lưu tin nhắn vào MongoDB
        const newMessage = new Message({ chatRoomId, sender, content });
        await newMessage.save();

        // Gửi tin nhắn đến room tương ứng
        io.to(chatRoomId).emit("receiveMessage", { sender, content });
    });

    socket.on("joinRoom", ({ chatRoomId }) => {
        socket.join(chatRoomId);
        console.log(`✅ User ${socket.id} joined room ${chatRoomId}`);
    });

    socket.on("disconnect", () => {
        console.log("🔴 User disconnected", socket.id);
    });
});

const PORT = process.env.PORT || 5001;
server.listen(PORT, () => console.log(`🚀 Socket server running on port ${PORT}`));
