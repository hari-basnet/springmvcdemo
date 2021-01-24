package com.habasnet.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habasnet.springdemo.model.Student;
import com.habasnet.springdemo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {

		return studentRepository.save(student);
	}

	public List<Student> getAllStudent() {

		return studentRepository.findAll();
	}
}
