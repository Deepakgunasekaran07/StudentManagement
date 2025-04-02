package com.program.restapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students") // Use plural naming convention
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rollNo;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private double percentage; // Changed to double (better for precision)

	@Column(nullable = false)
	private String branch;

	@Column(nullable = true)
	private String email;

	@Column(nullable = true)
	private Integer age;

	// Constructors
	public Student() {}

	public Student(String name, double percentage, String branch, String email, Integer age) {
		this.name = name;
		this.percentage = percentage;
		this.branch = branch;
		this.email = email;
		this.age = age;
	}

	// Getters and Setters
	public Long getRollNo() {
		return rollNo;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}