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

import com.safeschoolmanager.app.entities.Schedule;
import com.safeschoolmanager.app.entities.SchedulePKId;
import com.safeschoolmanager.app.services.ScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	public ScheduleController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/allschedules")
	public List<Schedule> getAllSchedule() {
		return scheduleService.getAllSchedules();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no Schedule found
	 */

	@GetMapping("/{schedulepkId}")
	public Schedule getScheduleById(@PathVariable SchedulePKId schedulepkId) {
		return scheduleService.getScheduleById(schedulepkId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */

	@PostMapping("/add")
	public ResponseEntity<?> addNewSchedule(@RequestBody Schedule schedule) {
		System.out.println("in add schedule" + schedule);
		try {
			return new ResponseEntity<>(scheduleService.addNewSchedule(schedule), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{schedulepkId}")
	public ResponseEntity<?> updateAdmin(@PathVariable SchedulePKId schedulepkId, @RequestBody Schedule schedule) {
		System.out.println("in update schedule" + schedule);
		try {
			return new ResponseEntity<>(scheduleService.updateSchedule(schedulepkId, schedule), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{schedulepkId}")
	public ResponseEntity<?> deleteSchedule(@PathVariable SchedulePKId schedulepkId) {

		try {
			return new ResponseEntity<>(scheduleService.deleteSchedule(schedulepkId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
