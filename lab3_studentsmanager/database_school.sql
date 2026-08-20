-- 1. Tạo cơ sở dữ liệu school
CREATE DATABASE school;
GO

-- 2. Chỉ định sử dụng cơ sở dữ liệu vừa tạo
USE school;
GO

-- 3. Tạo bảng students nằm bên trong database school
CREATE TABLE students (
    id INT PRIMARY KEY,
    name NVARCHAR(100),
    age INT,
    email NVARCHAR(100)
);
GO

-- 4. Thêm dữ liệu mẫu
INSERT INTO students VALUES
(1, N'Nguyễn Văn A', 20, 'a@gmail.com'),
(2, N'Trần Thị B', 21, 'b@gmail.com'),
(3, N'Lê Văn C', 19, 'c@gmail.com');
GO

-- THÊM CỘT GIỚI TÍNH 
ALTER TABLE students ADD gender NVARCHAR(10);
GO
UPDATE students SET gender = N'Nam' WHERE id IN (1, 3);
UPDATE students SET gender = N'Nữ' WHERE id = 2;

-- 5. Lệnh truy vấn kiểm tra dữ liệu
SELECT * FROM students;


