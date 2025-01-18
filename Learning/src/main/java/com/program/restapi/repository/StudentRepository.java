package com.program.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.program.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	//in jparepository already we have the methods click on it

}
