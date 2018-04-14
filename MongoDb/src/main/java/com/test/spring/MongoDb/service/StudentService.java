package com.test.spring.MongoDb.service;

import java.util.List;

import com.test.spring.MongoDb.model.Student;


public interface StudentService {
	
    List<Student> listAll();

    Student getByStudentId(String studentId);

    Student saveOrUpdate(Student student);

    void delete(String studentId);


}
