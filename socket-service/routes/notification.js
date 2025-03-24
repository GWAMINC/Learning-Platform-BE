const express = require("express");
const Notification = require("../model/Notification");

const router = express.Router();

/**
 * 1️⃣ 🟢 Lấy tất cả thông báo của user
 */
router.get("/all/:userId", async (req, res) => {
    try {
        const userId = parseInt(req.params.userId);
        const notifications = await Notification.find({ userIds: userId }).sort({ createdAt: -1 });
        res.json({ success: true, notifications });
    } catch (error) {
        res.status(500).json({ success: false, message: "Lỗi server", error });
    }
});

/**
 * 2️⃣ 🟠 Lấy tất cả thông báo theo courseId
 */
router.get("/course/:courseId", async (req, res) => {
    try {
        const courseId = parseInt(req.params.courseId);
        const notifications = await Notification.find({ refId: courseId }).sort({ createdAt: -1 });
        res.json({ success: true, notifications });
    } catch (error) {
        res.status(500).json({ success: false, message: "Lỗi server", error });
    }
});

/**
 * 3️⃣ 🟡 Lấy thông báo chưa đọc của user
 */
router.get("/unread/:userId", async (req, res) => {
    try {
        const userId = parseInt(req.params.userId);
        const notifications = await Notification.find({ 
            userIds: userId,
            readBy: { $ne: userId } // Lọc những thông báo chưa đọc
        }).sort({ createdAt: -1 });

        res.json({ success: true, notifications });
    } catch (error) {
        res.status(500).json({ success: false, message: "Lỗi server", error });
    }
});

/**
 * 4️⃣ 🟣 Đánh dấu tất cả thông báo của user là đã đọc
 */
router.put("/mark-as-read/:userId", async (req, res) => {
    try {
        const userId = parseInt(req.params.userId);
        await Notification.updateMany(
            { userIds: userId, readBy: { $ne: userId } },
            { $addToSet: { readBy: userId } } // Thêm userId vào danh sách đã đọc
        );

        res.json({ success: true, message: "Tất cả thông báo đã được đánh dấu là đã đọc" });
    } catch (error) {
        res.status(500).json({ success: false, message: "Lỗi server", error });
    }
});

/**
 * 5️⃣ 🔴 Xóa tất cả thông báo của user
 */
router.delete("/delete-all/:userId", async (req, res) => {
    try {
        const userId = parseInt(req.params.userId);
        await Notification.deleteMany({ userIds: userId });
        res.json({ success: true, message: "Đã xóa tất cả thông báo" });
    } catch (error) {
        res.status(500).json({ success: false, message: "Lỗi server", error });
    }
});

/**
 * 6️⃣ 🔵 Xóa một thông báo theo ID
 */
router.delete("/delete/:notificationId", async (req, res) => {
    try {
        const { notificationId } = req.params;
        await Notification.findByIdAndDelete(notificationId);
        res.json({ success: true, message: "Thông báo đã bị xóa" });
    } catch (error) {
        res.status(500).json({ success: false, message: "Lỗi server", error });
    }
});

module.exports = router;
