// CHỨC NĂNG:REPONSITORY: Lớp này đại diện cho tầng Repository 
// (tầng dữ liệu) của ứng dụng quản lý sinh viên

package com.example.lab3_studentsmanager.repository;
import java.util.List;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.lab3_studentsmanager.entity.Student;


public interface StudentRepository extends JpaRepository<Student, UUID> {


    List<Student> findByStudentCodeContainingIgnoreCaseOrFullNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrPhoneContainingIgnoreCase(
            String studentCode,
            String fullName,
            String email,
            String phone);
}

