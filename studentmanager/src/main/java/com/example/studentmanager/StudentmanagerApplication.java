package com.example.studentmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@SpringBootApplication
public class StudentmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagerApplication.class, args);
	}

	// http://localhost:8080/api/hello
	@GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }

	// http://localhost:8080/api/greet?name=Hieu
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
    	return "Xin chào " + name;
	}

	// http://localhost:8080/api/students/search?keyword=java&page=2
	@GetMapping("/students/search")
	public String search(
        	@RequestParam String keyword,
        	@RequestParam(defaultValue = "1") int page) {
    	return "keyword=" + keyword + ", page=" + page;
	}

	//	http://localhost:8080/api/students/10
	@GetMapping("/students/{id}")
	public String getStudent(@PathVariable int id) {
    	return "Sinh viên có mã: " + id;
	}

	// http://localhost:8080/api/student
    @GetMapping("/student")
    public student getStudentObject() {
        return new student(1, "Nguyễn Văn A", 20);
    }


	// http://localhost:8080/api/students
	@GetMapping("/students")
	public List getStudents() {
    	List list = new ArrayList<>();
    	list.add(new student(1, "A", 20));
    	list.add(new student(2, "B", 21));
    	return list;
}
}
