package com.example.springjpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.model.Student;
import com.example.springjpa.service.Studentservice;

@RestController
public class StudentController {

	@Autowired
	private Studentservice studentservice;
	
	@PostMapping("/addStudent")
	public Student postDetails( @RequestBody Student student) {
		return studentservice.saveDetails(student);	}
	

	@GetMapping("/addStudent")
	public ResponseEntity <List<Student>> Details( @RequestBody Student student) {
		return new ResponseEntity<>(studentservice.getDetails(), HttpStatus.OK);	
		}
	
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id){
		
Optional<Student> student = studentservice.getStudentById(id);
    	
    	if(student.isPresent()) {
    		studentservice.delete(id);
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
	
    }
}
