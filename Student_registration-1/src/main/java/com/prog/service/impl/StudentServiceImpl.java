package com.prog.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prog.entity.Student;
import com.prog.repository.StudentRepository;
import com.prog.repository.StudentSearchRepository;
import com.prog.service.StudentService;

@Service
@CacheConfig(cacheNames={"Students"})
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	private StudentSearchRepository studentSearchRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository,StudentSearchRepository studentSearchRepository) {
		super();
		this.studentRepository = studentRepository;
		this.studentSearchRepository = studentSearchRepository;
	}
	

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		student.setId(UUID.randomUUID().toString());
		studentSearchRepository.save(performMappingToStudentSolr(student));
		return studentRepository.save(student);
	}

	@Override
	@Cacheable(key="#id")
	public Student getStudentById(String id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		studentSearchRepository.save(performMappingToStudentSolr(student));
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(String id) {
		System.out.println(id);
		studentSearchRepository.deleteById(id);
		studentRepository.deleteById(id);	
	}
	
	public com.prog.entity.solr.Student performMappingToStudentSolr(Student student) {
		com.prog.entity.solr.Student studentSolr = new com.prog.entity.solr.Student();
		studentSolr.setId(student.getId());
		studentSolr.setFirstName(student.getFirstName());
		studentSolr.setLastName(student.getLastName());	
		studentSolr.setDept(student.getDept());
		studentSolr.setDOB(student.getDOB());
		studentSolr.setEmail(student.getEmail());
		studentSolr.setPhone(student.getPhone());
		return studentSolr;
	}  
}