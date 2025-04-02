package com.program.restapi.service;

import com.program.restapi.entity.Student;
import com.program.restapi.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Create a new student
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update student details
    public Student updateStudent(Long id, Student studentDetails) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentDetails.getName());
                    student.setPercentage(studentDetails.getPercentage());
                    student.setBranch(studentDetails.getBranch());
                    student.setEmail(studentDetails.getEmail());
                    student.setAge(studentDetails.getAge());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    // Delete student
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        studentRepository.delete(student);
    }
}