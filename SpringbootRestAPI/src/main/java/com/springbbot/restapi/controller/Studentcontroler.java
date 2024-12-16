package com.springbbot.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbbot.restapi.entity.Student;
import com.springbbot.restapi.repository.StudentRepository;

@RestController
public class Studentcontroler {
	//get all the students
	
	@Autowired
	StudentRepository repo;
	@GetMapping("/students")
	public List<Student> getallstudents() {
		List<Student> student=repo.findAll();
		return student;
		
	}
	
	
	@GetMapping("students/findid {id}")
	public Optional<Student> findstubyid(@PathVariable int id){
		Optional<Student> student=repo.findById(id);
		return student;
	}
	
	@PostMapping("/students/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createstudent(@RequestBody Student student){
		repo.save(student);
		
	}
	
	@PutMapping("/students/update")
	public ResponseEntity<Student> updateStudent(@RequestParam int id, @RequestParam String name) {
	    Optional<Student> ostudent = repo.findById(id);
	    if (ostudent.isPresent()) {
	        Student student = ostudent.get();
	        student.setName(name);

	        repo.save(student);
	        return ResponseEntity.ok(student); // Return the updated student with status 200
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if the student is not found
	    }
	}

	
	
}
