package com.safeschoolmanager.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeschoolmanager.app.entities.Student;
import com.safeschoolmanager.app.services.StudentService;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/allstudents")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no student found
	 */

	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable Integer studentId) {
		return studentService.getStudentById(studentId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */
	@GetMapping("/byName/{studentName}")
	public ResponseEntity<?> getStudentByName(@PathVariable String studentName) {
		Student student = studentService.getStudentByName(studentName);
		if (student != null)// if student exist
		{
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addNewStudent(@RequestBody Student student) {
		System.out.println("in add student" + student);
		try {
			return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{studentId}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
		System.out.println("in update student" + student);
		try {
			return new ResponseEntity<>(studentService.updateStudent(studentId, student), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId) {

		try {
			return new ResponseEntity<>(studentService.deleteStudent(studentId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
