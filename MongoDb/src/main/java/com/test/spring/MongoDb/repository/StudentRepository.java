package com.test.spring.MongoDb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.spring.MongoDb.model.Student;

/**
 * @author prkumar
 */

public interface StudentRepository extends MongoRepository<Student, String>{
	
	public Student findByStudentId(String studentId);
	
}
