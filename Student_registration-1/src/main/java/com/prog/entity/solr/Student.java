package com.prog.entity.solr;

import java.io.Serializable;

import javax.persistence.Id;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;


@SolrDocument(collection = "students")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7109001549274805142L;

	@Id
	@Field
	private String id;
	
	@Field
	private String firstName;
	
	@Field
	private String lastName;
	
	@Field
	private String email;
	
	@Field
	private String dept;
	
	@Field
	private String Phone;
	
	@Field
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

   
