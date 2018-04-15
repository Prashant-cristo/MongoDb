package com.test.spring.MongoDb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.spring.MongoDb.model.Student;
import com.test.spring.MongoDb.service.StudentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author prkumar
 */

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/add")
	@ApiOperation(value = "Add list of  students to the database", notes = "Add list of  students to the database.", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not working"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden") })
	public String save() {
		studentService.saveOrUpdate(new Student("ST1", "Prashant", "Cache"));
		studentService.saveOrUpdate(new Student("ST2", "Surya", "Batch"));
		studentService.saveOrUpdate(new Student("ST3", "Pratik", "Payment"));
		studentService.saveOrUpdate(new Student("ST4", "Prakash", "Devops"));
		studentService.saveOrUpdate(new Student("ST5", "Priya", "DSC"));

		return "Done";
	}

	@RequestMapping(value = "/add/student", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Add unique student to the database", notes = "Add unique student to the database.", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not working"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden") })
	public String saveStudent(@ApiParam(value = "StudentData", required = true) @RequestBody Student student) {
		// save a single Student
		studentService.saveOrUpdate(student);

		return "Done";
	}

	@RequestMapping(value = "/findall", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ApiOperation(value = "Find all student from  the database", notes = "Find all student from the database.", response = Student.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not working"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden") })
	public List<Student> liststudents() {
		List<Student> students = studentService.listAll();

		return students;
	}

	@RequestMapping(value = "/find/studentId/{studentId}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	@ApiOperation(value = "Find unique student from the database", notes = "Find unique student from the database.", response = Student.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not working"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden") })
	public Student getstudent(@ApiParam(value = "StudentId", required = true) @PathVariable String studentId) {
		Student student = studentService.getByStudentId(studentId);
		return student;
	}

	@RequestMapping(value = "/student/delete/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a particular student from the database", notes = "Delete a particular student from the database.", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Service not working"),
			@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 403, message = "Forbidden") })
	public String delete(@ApiParam(value = "StudentId", required = true) @PathVariable String id) {
		studentService.delete(id);
		return "Deleted";
	}
}
