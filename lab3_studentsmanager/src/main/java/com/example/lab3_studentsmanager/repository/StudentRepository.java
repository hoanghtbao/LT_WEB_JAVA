package com.example.lab3_studentsmanager.repository;
import java.util.List;
import com.example.lab3_studentsmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Để trống thế này là đủ! 
    // JpaRepository đã tự động viết sẵn cho bạn các lệnh SQL cơ bản: Thêm, Sửa, Xóa, Tìm kiếm.

    // Spring Boot tự động dịch tên hàm này thành câu lệnh SQL LIKE %keyword%
    List<Student> findByNameContaining(String keyword);
}
