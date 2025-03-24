const amqp = require("amqplib");
const Notification = require("./model/Notification"); // Import model Notification

// Kết nối RabbitMQ để nhận thông báo từ backend Java
async function connectRabbitMQ(io) {
    try {
        //const connection = await amqp.connect("amqp://localhost");
        const connection = await amqp.connect("amqp://guest:guest@rabbitmq:5672/");
        const channel = await connection.createChannel();

        const queue = "notificationQueue";
        await channel.assertQueue(queue, { durable: true });

        console.log("🐰 ✅ RabbitMQ connected, waiting for messages...");

        channel.consume(queue, async (msg) => {
            if (msg !== null) {
                console.log("📩 Received:", msg.content.toString());
                const message = JSON.parse(msg.content.toString());
                console.log("📢 New Notification:", message);

                // Tạo đối tượng Notification
                const newNotification = new Notification({
                    type: message.type,
                    refId: message.refId,
                    content: message.content,
                    userIds: message.userIds,
                });

                // Lưu vào MongoDB và lấy _id
                const savedNotification = await newNotification.save();

                // Sau khi lưu, gửi WebSocket kèm theo _id
                for (const userId of message.userIds) {
                    io.to(`user_${userId}`).emit("newNotification", {
                        _id: savedNotification._id, // Gửi ID về FE
                        refId: message.refId,
                        type: message.type,
                        content: message.content,
                        broadcast: false,
                        createdAt: savedNotification.createdAt, // Lấy từ DB để chính xác hơn
                        readBy: [],
                    });
                }

                channel.ack(msg);
            }
        });
    } catch (error) {
        console.error("❌ RabbitMQ connection error:", error);
    }
}

module.exports = connectRabbitMQ;
