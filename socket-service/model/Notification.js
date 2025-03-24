const mongoose = require("mongoose");

const notificationSchema = new mongoose.Schema({
    type: {
        type: String,
        required: true,
    },
    refId: {
        type: Number, // ID từ MySQL (userId, courseId, ...)
        default: null
    },
    content: {
        type: String,
        required: true
    },
    userIds: {
        type: [Number], // Danh sách userId từ MySQL
        default: []
    },
    broadcast: {
        type: Boolean,
        default: false
    },
    createdAt: {
        type: Date,
        default: Date.now
    },
    readBy: {
        type: [Number], // Danh sách userId đã đọc
        default: []
    }
});

const Notification = mongoose.model("Notification", notificationSchema);
module.exports = Notification;
