package com.example.lab3_studentsmanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "students") // Tên này phải trùng khớp chính xác với tên bảng trong SQL Server
public class Student {

    @Id
    private int id;
    private String name;
    private int age;
    private String email;
    private String gender;

    // --- BẮT BUỘC PHẢI TẠO GETTER VÀ SETTER ---
    // (Nếu không có, Thymeleaf và Spring Boot sẽ không lấy được dữ liệu)

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
