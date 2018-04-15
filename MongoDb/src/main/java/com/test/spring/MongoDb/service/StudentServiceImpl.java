package com.test.spring.MongoDb.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.MongoDb.model.Student;
import com.test.spring.MongoDb.repository.StudentRepository;

/**
 * @author prkumar
 */

@Service
public class StudentServiceImpl implements StudentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> listAll() {
		LOGGER.info("Entering method listAll {}", System.currentTimeMillis());
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students::add); // fun with Java 8
		LOGGER.info("Exiting method listAll {}", System.currentTimeMillis());
		return students;
	}

	@Override
	public Student getByStudentId(String studentId) {
		return studentRepository.findByStudentId(studentId);
	}

	@Override
	public Student saveOrUpdate(Student student) {
		LOGGER.info("Entering method saveOrUpdate {}", System.currentTimeMillis());
		studentRepository.save(student);
		LOGGER.info("Exiting method saveOrUpdate {}", System.currentTimeMillis());
		return student;
	}

	@Override
	public void delete(String id) {
		studentRepository.delete(id);
	}

}
