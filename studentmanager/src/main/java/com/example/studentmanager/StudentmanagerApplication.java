package com.example.studentmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
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

	
	// Bài 1: http://localhost:8080/api/hello
	@GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot API";
    }

	// Bài 2: http://localhost:8080/api/students/10
	@GetMapping("/students/{id}")
	public String getStudent(@PathVariable int id) {
    	return "Sinh viên có mã: " + id;
	}

	// Bài 3A: http://localhost:8080/api/greet?name=Hieu
	@GetMapping("/greet")
	public String greet(@RequestParam String name) {
    	return "Xin chào " + name;
	}
	
	// Bài 3B: http://localhost:8080/api/searchStudent?name=Nam&age=20
	@GetMapping("/searchStudent")
	public String searchStudent(@RequestParam String name,@RequestParam(defaultValue = "1") int age) {
    return "Tên=" + name + ", tuổi=" + age;
	}	



	//Bài 4A: http://localhost:8080/api/student
    @GetMapping("/student")
    public student getStudentObject() {
        return new student(1, "Nguyễn Văn A", 20);
    }

	//Bài 4B: http://localhost:8080/api/studentall
	@GetMapping("/studentall")
	public List getStudents() {
    	List list = new ArrayList<>();
    	list.add(new student(1, "A", 20));
    	list.add(new student(2, "B", 21));
    	return list;
	}
	// Bài 5: http://localhost:8080/api/getstudent
	@GetMapping("/getstudent")
	public String getStudents(
        @RequestHeader("Authorization") String authorization) {
    	return "Authorization = " + authorization;
	}
  
	// : http://localhost:8080/api/students/search?keyword=java&page=2
	@GetMapping("/students/search")
	public String search(
        	@RequestParam String keyword,
        	@RequestParam(defaultValue = "1") int page) {
    	return "keyword=" + keyword + ", page=" + page;
	}

	
	


	
}
