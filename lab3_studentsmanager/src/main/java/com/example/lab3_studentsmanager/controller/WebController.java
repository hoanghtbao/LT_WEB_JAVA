package com.example.lab3_studentsmanager.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lab3_studentsmanager.entity.Student;
import com.example.lab3_studentsmanager.service.StudentService;

@Controller
public class WebController {

    private final StudentService studentService;

    public WebController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/students";
    }

    @GetMapping("/students")
    public String viewStudents(Model model, @RequestParam(required = false) String keyword) {
        List<Student> students = (keyword != null && !keyword.trim().isEmpty())
                ? studentService.search(keyword)
                : studentService.getAll();

        model.addAttribute("students", students);
        model.addAttribute("keyword", keyword);
        model.addAttribute("student", new Student());
        return "students"; // Trả về file students.html trong templates
    }
}


