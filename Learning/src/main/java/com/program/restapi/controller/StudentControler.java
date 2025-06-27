package com.program.restapi.controller;

import com.program.restapi.entity.Student;
import com.program.restapi.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*") // Allow all origins (you can restrict it in prod)
public class StudentControler {

	private final StudentService studentService;

	public StudentControler(StudentService studentService) {
		this.studentService = studentService;
	}

	// ✅ GET all students
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}

	// ✅ GET student by ID
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		return ResponseEntity.ok(studentService.getStudentById(id));
	}

	// ✅ CREATE a new student
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.saveStudent(student));
	}

	// ✅ UPDATE student by ID
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return ResponseEntity.ok(studentService.updateStudent(id, student));
	}

	// ✅ DELETE student by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student deleted successfully!");
	}

	// ✅ Test endpoint to create a sample student (optional)
	@GetMapping("/test-create")
	public ResponseEntity<String> testCreateStudent() {
		Student sample = new Student();
		sample.setName("Sample Student");
		sample.setBranch("IT");
		studentService.saveStudent(sample);
		return ResponseEntity.ok("Sample student created!");
	}
}