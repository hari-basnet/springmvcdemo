package com.habasnet.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.habasnet.springdemo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
