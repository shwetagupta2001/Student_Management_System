package com.prog.controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.prog.entity.Student;
import com.prog.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;
	
	

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/show/{id}")
	public String getStudent(@PathVariable String id, Model model) {
		model.addAttribute("students", studentService.getStudentById(id));
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") Student student,BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            return "create_student";
        } 
        
            
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable String id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable String id,
			@ModelAttribute("student") Student student,
			Model model) {
		
		
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setDOB(student.getDOB());
		existingStudent.setPhone(student.getPhone());
		existingStudent.setDept(student.getDept());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable String id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}