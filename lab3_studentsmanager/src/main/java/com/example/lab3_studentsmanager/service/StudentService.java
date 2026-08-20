package com.example.lab3_studentsmanager.service;

import com.example.lab3_studentsmanager.repository.StudentRepository;
import com.example.lab3_studentsmanager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Hàm tìm kiếm sinh viên
    public List<Student> searchStudents(String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            return repository.findByNameContaining(keyword);
        }
        return repository.findAll();
    }

    // Hàm lấy chi tiết 1 sinh viên theo ID
    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }
}
