package com.prog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog.entity.Student;



public interface StudentRepository extends JpaRepository<Student, String>{

}