package com.example.lab3_studentsmanager.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class WebController {
    @GetMapping("/students")
    public String viewStudents() {
        return "students"; // Trả về file students.html trong templates
    }
}
