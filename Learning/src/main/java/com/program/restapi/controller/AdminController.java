package com.program.restapi.controller;

import com.program.restapi.entity.Student;
import com.program.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable("id") Long id) { // Changed int to Long
        return studentService.getStudentById(id);
    }

    // Add new student
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Update student details
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student studentDetails) { // Changed int to Long
        return studentService.updateStudent(id, studentDetails);
    }

    // Delete student
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id) { // Changed int to Long
        studentService.deleteStudent(id);
        return "Student with ID " + id + " has been deleted";
    }
}