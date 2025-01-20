USE enrolldb;

-- CoursePayments Table (Lưu thông tin thanh toán khóa học)
CREATE TABLE CoursePayments (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                course_id INT NOT NULL,
                                user_id INT NOT NULL,
                                payment_method_id INT NOT NULL,
                                amount DECIMAL(10, 2) NOT NULL,
                                total_amount DECIMAL(10, 2) NOT NULL,
                                payment_date DATETIME DEFAULT NOW(),
                                status VARCHAR(20) NOT NULL DEFAULT 'pending',
                                created_at DATETIME DEFAULT NOW(),
                                updated_at DATETIME DEFAULT NOW()
);

-- CourseEnrollments Table (Lưu danh sách học viên đã ghi danh)
CREATE TABLE CourseEnrollments (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   course_id INT NOT NULL,
                                   user_id INT NOT NULL,
                                   progress FLOAT DEFAULT 0,
                                   enrolled_at DATETIME DEFAULT NOW()
);

-- Cart Table (Giỏ hàng của sinh viên)
CREATE TABLE IF NOT EXISTS Cart (
                                    cart_id INT AUTO_INCREMENT PRIMARY KEY,
                                    student_id INT NOT NULL,
                                    total_price DECIMAL(10, 2) DEFAULT 0.00,
                                    cart_status ENUM('active', 'checked_out') DEFAULT 'active',
                                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- CartItems Table (Các khóa học trong giỏ hàng)
CREATE TABLE IF NOT EXISTS CartItems (
                                         cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
                                         cart_id INT NOT NULL,
                                         course_id INT NOT NULL,
                                         quantity INT DEFAULT 1,
                                         price DECIMAL(10, 2) NOT NULL,
                                         added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                         FOREIGN KEY (cart_id) REFERENCES Cart(cart_id) ON DELETE CASCADE
);