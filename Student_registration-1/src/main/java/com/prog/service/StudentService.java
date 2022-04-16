package com.prog.service;

import java.util.List;

import com.prog.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();

	Student saveStudent(Student student);

	Student getStudentById(String id);

	Student updateStudent(Student student);

	void deleteStudentById(String id);

}
