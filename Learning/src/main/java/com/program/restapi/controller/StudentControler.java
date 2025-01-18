package com.program.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.program.restapi.entity.Student;
import com.program.restapi.repository.StudentRepository;

@RestController
public class StudentControler {
	@Autowired
	StudentRepository repo;
	//shortcut(ctrl+shift+o)
	//localhost:8080/students(type in postman)
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){//to get all the students we will write one method
		List<Student>students=repo.findAll();//ithula all the student details fetch pannikalam
		return students;
		
	}
	@GetMapping("/students/{id}")//intha commandla getting student details by there id 
	public Student getStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		return student;
	}
	@PostMapping("/student/add")//whenever we hit this uri in postman it will add the following detailes in postman
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	@PutMapping("/student/update/{id}")//we will update student detail using there id in the following function
	public void updatestudents(@PathVariable int id) {//pathvariable user inputku kuduka use pannuvom
		Student student=repo.findById(id).get();
		student.setName("Madhavan");
		student.setPercentage(88);
		repo.save(student);
		 
		
	}
	@DeleteMapping("/student/delete/{id}")
	public void removestudent(@PathVariable int id) {
		Student student =repo.findById(id).get();
		repo.delete(student);
	}

}
