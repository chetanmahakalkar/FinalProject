package com.safeschoolmanager.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safeschoolmanager.app.entities.School;
import com.safeschoolmanager.app.services.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private SchoolService schoolService;

	public SchoolController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/allschools")
	public List<School> getAllSchools() {
		return schoolService.getAllSchools();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no school found
	 */

	@GetMapping("/{schoolId}")
	public School getSchoolById(@PathVariable Integer schoolId) {
		return schoolService.getSchoolById(schoolId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */
	@GetMapping("/byName/{schoolName}")
	public ResponseEntity<?> getSchoolByName(@PathVariable String schoolName) {
		School school = schoolService.getSchoolByName(schoolName);
		if (school != null)// if school exist
		{
			return new ResponseEntity<>(school, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/{schoolId}")
	public ResponseEntity<?> addNewSchool(@RequestBody School school) {
		System.out.println("in add school" + school);
		try {
			return new ResponseEntity<>(schoolService.addNewSchool(school), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{schoolId}")
	public ResponseEntity<?> updateSchool(@PathVariable Integer schoolId, @RequestBody School school) {
		System.out.println("in update school" + school);
		try {
			return new ResponseEntity<>(schoolService.updateSchool(schoolId, school), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{schoolId}")
	public ResponseEntity<?> deleteSchool(@PathVariable Integer schoolId) {

		try {
			return new ResponseEntity<>(schoolService.deleteSchool(schoolId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
