USE coursedb;

-- Courses Table
CREATE TABLE Courses (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(100) NOT NULL,
                         description TEXT,
                         created_at DATETIME DEFAULT NOW(),
                         updated_at DATETIME DEFAULT NOW()
);

-- CourseUnits Table
CREATE TABLE CourseUnits (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             name VARCHAR(100) NOT NULL,
                             course_id INT NOT NULL,
                             created_at DATETIME DEFAULT NOW(),
                             updated_at DATETIME DEFAULT NOW(),
                             FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);

-- Lessons Table
CREATE TABLE Lessons (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         content TEXT,
                         course_unit_id INT NOT NULL,
                         created_at DATETIME DEFAULT NOW(),
                         updated_at DATETIME DEFAULT NOW(),
                         FOREIGN KEY (course_unit_id) REFERENCES CourseUnits(id) ON DELETE CASCADE
);

-- Media Table
CREATE TABLE Media (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       type VARCHAR(50) NOT NULL,
                       path TEXT NOT NULL,
                       description TEXT,
                       created_at DATETIME DEFAULT NOW(),
                       updated_at DATETIME DEFAULT NOW()
);

-- LessonMedia Table
CREATE TABLE LessonMedia (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             lesson_id INT NOT NULL,
                             media_id INT NOT NULL,
                             created_at DATETIME DEFAULT NOW(),
                             updated_at DATETIME DEFAULT NOW(),
                             FOREIGN KEY (lesson_id) REFERENCES Lessons(id) ON DELETE CASCADE,
                             FOREIGN KEY (media_id) REFERENCES Media(id) ON DELETE CASCADE
);

-- Assignments Table
CREATE TABLE Assignments (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             lesson_id INT NOT NULL,
                             title VARCHAR(255) NOT NULL,
                             description TEXT,
                             created_at DATETIME DEFAULT NOW(),
                             updated_at DATETIME DEFAULT NOW(),
                             FOREIGN KEY (lesson_id) REFERENCES Lessons(id) ON DELETE CASCADE
);

-- Categories Table
CREATE TABLE Categories (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(50) NOT NULL UNIQUE,
                            description TEXT,
                            created_at DATETIME DEFAULT NOW(),
                            updated_at DATETIME DEFAULT NOW()
);

-- CourseCategories Table
CREATE TABLE CourseCategories (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  course_id INT NOT NULL,
                                  category_id INT NOT NULL,
                                  FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE,
                                  FOREIGN KEY (category_id) REFERENCES Categories(id) ON DELETE CASCADE
);

-- Reviews Table
CREATE TABLE Reviews (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         course_id INT NOT NULL,
                         user_id INT NOT NULL,
                         rating INT NOT NULL,
                         comment TEXT,
                         created_at DATETIME DEFAULT NOW(),
                         updated_at DATETIME DEFAULT NOW()
);

-- Coupons Table
CREATE TABLE Coupons (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         code VARCHAR(50) NOT NULL UNIQUE,
                         discount_percentage DECIMAL(5, 2) NOT NULL,
                         expiration_date DATETIME NOT NULL,
                         created_by INT NOT NULL,
                         created_at DATETIME DEFAULT NOW()
);

-- CourseStudent Table (Mối quan hệ giữa khóa học và sinh viên)
CREATE TABLE IF NOT EXISTS CourseStudent (
                                             course_id INT NOT NULL,
                                             student_id INT NOT NULL,
                                             enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                             PRIMARY KEY (course_id, student_id),
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
    );

-- CourseTeacher Table (Mối quan hệ giữa khóa học và giảng viên)
CREATE TABLE IF NOT EXISTS CourseTeacher (
                                             course_id INT NOT NULL,
                                             teacher_id INT NOT NULL,
                                             PRIMARY KEY (course_id, teacher_id),
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
    );

-- Thêm cột order_number vào bảng Lessons
ALTER TABLE Lessons ADD COLUMN order_number INT NOT NULL;