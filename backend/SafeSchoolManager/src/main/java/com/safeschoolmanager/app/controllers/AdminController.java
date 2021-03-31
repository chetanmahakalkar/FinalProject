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

import com.safeschoolmanager.app.entities.Admin;
import com.safeschoolmanager.app.services.AdminService;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	public AdminController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/alladmins")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no school found
	 */

	@GetMapping("/{adminId}")
	public Admin getAdminById(@PathVariable Integer adminId) {
		return adminService.getAdminById(adminId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */
	@GetMapping("/byName/{adminName}")
	public ResponseEntity<?> getAdminByName(@PathVariable String adminName) {
		Admin admin = adminService.getAdminByName(adminName);
		if (admin != null)// if school exist
		{
			return new ResponseEntity<>(admin, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addNewAdmin(@RequestBody Admin admin) {
		System.out.println("in add admin" + admin);
		try {
			return new ResponseEntity<>(adminService.addNewAdmin(admin), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{adminId}")
	public ResponseEntity<?> updateAdmin(@PathVariable Integer adminId, @RequestBody Admin admin) {
		System.out.println("in update admin" + admin);
		try {
			return new ResponseEntity<>(adminService.updateAdmin(adminId, admin), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{adminId}")
	public ResponseEntity<?> deleteAdmin(@PathVariable Integer adminId) {

		try {
			return new ResponseEntity<>(adminService.deleteAdmin(adminId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}