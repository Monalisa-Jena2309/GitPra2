package com.example.springjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.springjpa.model.Student;
import com.example.springjpa.repository.Studntrepo;

@Service
public class Studentservice {
	@Autowired
private Studntrepo studntrepo;

public Student saveDetails(@RequestBody Student student) {
	System.out.println("the data is saved successfully!!! ");
	return studntrepo.save(student);
}
public List<Student> getDetails() {
	System.out.println("the data got successfully!!! ");
	return studntrepo.findAll();
}
public void  delete(int id) {
	System.out.println("the data is deleted  successfully!!! ");
	studntrepo.deleteById(id);;
}
public Optional<Student> getStudentById(int id) {
    return studntrepo.findById(id);
}
}


