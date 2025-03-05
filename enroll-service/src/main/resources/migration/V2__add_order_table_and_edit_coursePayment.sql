USE enrolldb;

-- Bảng Orders (Lưu thông tin đơn hàng)
CREATE TABLE IF NOT EXISTS Orders (
                                      order_id INT AUTO_INCREMENT PRIMARY KEY,
                                      user_id INT NOT NULL,
                                      total_amount DECIMAL(10, 2) NOT NULL,
    status ENUM('PENDING', 'CONFIRMED', 'CANCELED') DEFAULT 'PENDING',
    shipping_address TEXT,
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

-- Bảng CoursePayments (Lưu thông tin thanh toán khóa học)
ALTER TABLE CoursePayments
    ADD COLUMN order_id INT,
ADD COLUMN paypal_order_id VARCHAR(100),      -- ID giao dịch PayPal
ADD COLUMN paypal_status VARCHAR(50),        -- Trạng thái giao dịch PayPal (CREATED, APPROVED, COMPLETED)
ADD COLUMN paypal_checkout_link TEXT,        -- Link PayPal để thanh toán
ADD CONSTRAINT fk_coursepayments_order
FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE;

-- Bảng CourseEnrollments (Lưu danh sách học viên đã ghi danh)
CREATE TABLE IF NOT EXISTS CourseEnrollments (
                                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                                 course_id INT NOT NULL,
                                                 user_id INT NOT NULL,
                                                 progress FLOAT DEFAULT 0,
                                                 enrolled_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Bảng Cart (Giỏ hàng của sinh viên)
CREATE TABLE IF NOT EXISTS Cart (
                                    cart_id INT AUTO_INCREMENT PRIMARY KEY,
                                    student_id INT NOT NULL,
                                    total_price DECIMAL(10, 2) DEFAULT 0.00,
    cart_status ENUM('active', 'checked_out') DEFAULT 'active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

-- Bảng CartItems (Các khóa học trong giỏ hàng)
CREATE TABLE IF NOT EXISTS CartItems (
                                         cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
                                         cart_id INT NOT NULL,
                                         course_id INT NOT NULL,
                                         quantity INT DEFAULT 1,
                                         price DECIMAL(10, 2) NOT NULL,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cart_id) REFERENCES Cart(cart_id) ON DELETE CASCADE
    );
