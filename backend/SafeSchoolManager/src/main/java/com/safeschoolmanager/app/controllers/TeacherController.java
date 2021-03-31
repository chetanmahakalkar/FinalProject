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

import com.safeschoolmanager.app.entities.Teacher;
import com.safeschoolmanager.app.entities.TeacherPKId;
import com.safeschoolmanager.app.services.TeacherService;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	public TeacherController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/allteachers")
	public List<Teacher> getAllTeachers() {
		return teacherService.getAllTeachers();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no teacher found
	 */

	@GetMapping("/{teacherpkId}")
	public Teacher getTeacherById(@PathVariable TeacherPKId teacherpkId) {
		return teacherService.getTeacherById(teacherpkId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */
	@GetMapping("/byName/{teacherName}")
	public ResponseEntity<?> getTeacherByName(@PathVariable String teacherName) {
		Teacher teacher = teacherService.getTeacherByName(teacherName);
		if (teacher != null)// if teacher exist
		{
			return new ResponseEntity<>(teacher, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addNewTeacher(@RequestBody Teacher teacher) {
		System.out.println("in add teacher" + teacher);
		try {
			return new ResponseEntity<>(teacherService.addNewTeacher(teacher), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{teacherpkId}")
	public ResponseEntity<?> updateAdmin(@PathVariable TeacherPKId teacherpkId, @RequestBody Teacher teacher) {
		System.out.println("in update teacher" + teacher);
		try {
			return new ResponseEntity<>(teacherService.updateTeacher(teacherpkId, teacher), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{teacherpkId}")
	public ResponseEntity<?> deleteTeacher(@PathVariable TeacherPKId teacherpkId) {

		try {
			return new ResponseEntity<>(teacherService.deleteTeacher(teacherpkId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
