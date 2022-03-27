package com.prog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.solr.repository.SolrCrudRepository;



public interface StudentSearchRepository extends SolrCrudRepository<com.prog.entity.solr.Student, Long>{
	@Query(value = "select * from student s where s.firstName like %:keyword%", nativeQuery = true)
	List<com.prog.entity.solr.Student> findByFirstName(@Param("keyword") String keyword);

	List<com.prog.entity.solr.Student> findByLastName(String name);

	
	/* com.prog.entity.solr.Student findByName(String name); */

	com.prog.entity.solr.Student findByEmail(String email);



}

