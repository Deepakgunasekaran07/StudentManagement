package com.program.restapi.controller;

import com.program.restapi.entity.Student;
import com.program.restapi.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentControler {

	private final StudentService studentService;

	public StudentControler(StudentService studentService) {
		this.studentService = studentService;
	}

	// Get all students
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	// Get student by ID
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	// Create a new student
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.saveStudent(student));
	}

	// Update student
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return ResponseEntity.ok(studentService.updateStudent(id, student));
	}

	// Delete student
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully!");
	}
}