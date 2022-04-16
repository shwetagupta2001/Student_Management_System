package com.prog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EnableCaching
@EnableSolrRepositories
public class StudentRegistration1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentRegistration1Application.class, args);
	}

}