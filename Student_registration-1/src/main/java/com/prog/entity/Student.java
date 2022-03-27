package com.prog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7109001549274805142L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "FirstName can not be empty!!")
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@NotEmpty(message = "LastName can not be empty!!")
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	@Email(regexp="^(.+)@(.+)$", message="Invalid email")
	private String email;
	
	@Column(name = "dept")
	@NotEmpty(message = "Department can not be empty!!")
	private String dept;
	
	@Column(name = "Phone")
	@NotBlank(message="Field should not be empty")
	@Size(min=10,max=10, message="Invalid Phone_no")
	
	private String Phone;
	
	@Column(name = "DOB")
	@NotEmpty(message = "Date of Birth can not be empty!!")
	private String DOB;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, String email, String dept, String Phone, String DOB) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dept = dept;
		this.Phone = Phone;
		this.DOB = DOB;
	}
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}