package com.example.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.Student;
@Repository
public interface Studntrepo extends JpaRepository<Student,Integer>{

	
}
