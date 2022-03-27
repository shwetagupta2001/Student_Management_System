package com.prog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.prog.entity.solr.Student;
import com.prog.repository.StudentSearchRepository;


@Controller
@RequestMapping("student-search")
public class StudentSearchController {
	
	private StudentSearchRepository studentSearchRepository;
	
	public StudentSearchController(StudentSearchRepository studentSearchRepository) {
		super();
		this.studentSearchRepository = studentSearchRepository;
	}
	/*
	 * @GetMapping("/getStudentName/{name}") public Student
	 * getStudentByName(@PathVariable String name) { return
	 * studentSearchRepository.findByName(name); }
	 */
	
	@GetMapping("/find") 
	public String getStudentByFirstName(Student student,Model model,String keyword) { 
		List<Student> s= studentSearchRepository.findByFirstName(keyword);
		model.addAttribute("students", s);
		return "search";
	} 
	
	
	@GetMapping("/getStudentByLastName/{name}") 
	public List<Student> getStudentByLastName(@PathVariable String name) { 
		return studentSearchRepository.findByLastName(name);
	}
	
	@GetMapping("/getStudentByEmailId/{emailId}") 
	public Student getStudentByEmailId(@PathVariable String emailId) { 
		return studentSearchRepository.findByEmail(emailId);
	}
}
