USE userdb;

-- Users Table
CREATE TABLE Users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role ENUM('admin', 'teacher', 'student') NOT NULL DEFAULT 'student',
                       created_at DATETIME DEFAULT NOW(),
                       updated_at DATETIME DEFAULT NOW()
);

-- Bio Table (Thông tin profile của user)
CREATE TABLE Bio (
                     id INT AUTO_INCREMENT PRIMARY KEY,
                     user_id INT NOT NULL UNIQUE,
                     first_name VARCHAR(50) NOT NULL,
                     last_name VARCHAR(50) NOT NULL,
                     address TEXT,
                     phone VARCHAR(20),
                     gender ENUM('male', 'female', 'other'),
                     birth_date DATE,
                     bio TEXT,
                     avatar TEXT,
                     FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
);

-- PaymentMethods Table (Phương thức thanh toán của user)
CREATE TABLE PaymentMethods (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                user_id INT NOT NULL,
                                type VARCHAR(50) NOT NULL,
                                provider VARCHAR(50),
                                account_number VARCHAR(100) NOT NULL UNIQUE,
                                expiration_date DATE,
                                created_at DATETIME DEFAULT NOW(),
                                FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
);
