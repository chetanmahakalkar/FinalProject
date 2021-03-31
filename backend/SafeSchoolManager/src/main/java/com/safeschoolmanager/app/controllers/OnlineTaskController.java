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

import com.safeschoolmanager.app.entities.OnlineTask;
import com.safeschoolmanager.app.services.OnlineTaskService;

@CrossOrigin
@RestController
@RequestMapping("/onlinetask")
public class OnlineTaskController {
	@Autowired
	private OnlineTaskService onlineTaskService;

	public OnlineTaskController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/allonlineTasks")
	public List<OnlineTask> getAllOnlineTasks() {
		return onlineTaskService.getAllOnlineTasks();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no OnlineTask found
	 */

	@GetMapping("/{onlineTaskId}")
	public OnlineTask getOnlineTaskById(@PathVariable Integer onlineTaskId) {
		return onlineTaskService.getOnlineTaskById(onlineTaskId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */

	@PostMapping("/add")
	public ResponseEntity<?> addNewOnlineTask(@RequestBody OnlineTask onlineTask) {
		System.out.println("in add onlineTask" + onlineTask);
		try {
			return new ResponseEntity<>(onlineTaskService.addNewOnlineTask(onlineTask), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{onlineTaskId}")
	public ResponseEntity<?> updateOnlineTask(@PathVariable Integer onlineTaskId, @RequestBody OnlineTask onlineTask) {
		System.out.println("in update onlineTask" + onlineTask);
		try {
			return new ResponseEntity<>(onlineTaskService.updateOnlineTask(onlineTaskId, onlineTask), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{onlineTaskId}")
	public ResponseEntity<?> deleteOnlineTask(@PathVariable Integer onlineTaskId) {

		try {
			return new ResponseEntity<>(onlineTaskService.deleteOnlineTask(onlineTaskId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
