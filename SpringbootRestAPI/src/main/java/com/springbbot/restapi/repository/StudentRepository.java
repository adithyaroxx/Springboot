package com.springbbot.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbbot.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>  {

	void save(Optional<Student> student);

}
