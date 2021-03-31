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

import com.safeschoolmanager.app.entities.Classroom;
import com.safeschoolmanager.app.entities.ClassroomPKId;
import com.safeschoolmanager.app.services.ClassroomService;

@CrossOrigin
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	public ClassroomController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/allclassrooms")
	public List<Classroom> getAllClassroom() {
		return classroomService.getAllClassrooms();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no Classroom found
	 */

	@GetMapping("/{classroompkId}")
	public Classroom getClassroomById(@PathVariable ClassroomPKId classroompkId) {
		return classroomService.getClassroomById(classroompkId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */

	@PostMapping("/add")
	public ResponseEntity<?> addNewClassroom(@RequestBody Classroom classroom) {
		System.out.println("in add classroom" + classroom);
		try {
			return new ResponseEntity<>(classroomService.addNewClassroom(classroom), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{classroompkId}")
	public ResponseEntity<?> updateAdmin(@PathVariable ClassroomPKId classroompkId, @RequestBody Classroom classroom) {
		System.out.println("in update classroom" + classroom);
		try {
			return new ResponseEntity<>(classroomService.updateClassroom(classroompkId, classroom), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{classroompkId}")
	public ResponseEntity<?> deleteClassroom(@PathVariable ClassroomPKId classroompkId) {

		try {
			return new ResponseEntity<>(classroomService.deleteClassroom(classroompkId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
