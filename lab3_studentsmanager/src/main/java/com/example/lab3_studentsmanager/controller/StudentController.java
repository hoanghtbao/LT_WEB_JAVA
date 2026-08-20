package com.example.lab3_studentsmanager.controller;

import com.example.lab3_studentsmanager.entity.Student;
import com.example.lab3_studentsmanager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")

    // public String listStudents(Model model) {
    //     List<Student> students = studentService.getAllStudents();
    //     model.addAttribute("students", students); // Truyền dữ liệu từ Controller → HTML
    //     return "students"; // Trả về file students.html
    // }

    // Nâng cấp hàm listStudents() để có thể tìm kiếm sinh viên theo tên
    // 1. Cập nhật API danh sách (có hỗ trợ tìm kiếm)
    public String listStudents(Model model, @RequestParam(required = false) String keyword) {
        List<Student> students = studentService.searchStudents(keyword);
        model.addAttribute("students", students);
        model.addAttribute("keyword", keyword); // Giữ lại từ khóa trên ô tìm kiếm
        return "students";
    }

    // 2. Thêm API xem chi tiết sinh viên
    @GetMapping("/students/{id}")
    public String studentDetail(@PathVariable int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "student-detail"; // Sẽ tạo file này ở Bước 5
    }
}