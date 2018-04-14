package com.test.spring.MongoDb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.test.spring.MongoDb.model.Student;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { MongoDbApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class StudentTest {

	private static final String API_ROOT = "http://localhost:8080/api/student";

	private Student createRandomStudent() {
		Student student = new Student();
		student.setStudentId("STS1");
		student.setName("Prashant");
		student.setDesignation("SoftwareEngineer");
		return student;
	}

	private String createStudentAsUri(Student student) {
		Response response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(student)
				.post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("id");
	}

	@Test
	public void whenGetAllBooks_thenOK() {
		Response response = RestAssured.get(API_ROOT);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}

	@Test
	public void whenGetBooksByTitle_thenOK() {
		final Student student = createRandomStudent();
		createStudentAsUri(student);

		final Response response = RestAssured.get(API_ROOT + "/title/" + student.getStudentId());
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertTrue(response.as(List.class).size() > 0);
	}
}