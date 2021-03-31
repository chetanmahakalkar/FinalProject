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

import com.safeschoolmanager.app.entities.Principal;
import com.safeschoolmanager.app.services.PrincipalService;

@CrossOrigin
@RestController
@RequestMapping("/principal")
public class PrincipalController {
	@Autowired
	private PrincipalService principalService;

	public PrincipalController() {
		System.out.println("in constructor of" + getClass().getName());
	}

	@GetMapping("/allprincipals")
	public List<Principal> getAllPrincipals() {
		return principalService.getAllPrincipals();
	}

	/*
	 * Method 1:Using Optional as return type : Automatically to get data using
	 * optional to handle the errors while no Principal found
	 */

	@GetMapping("/{principalId}")
	public Principal getPrincipalById(@PathVariable Integer principalId) {
		return principalService.getPrincipalById(principalId);
	}

	/*
	 * Method 2:Using ResonseEntity : Manualy handle the errors if no data available
	 * using ResponseEntity NOTE: care should be taken that the path of url should
	 * be different to avoid ambiguity
	 */
	@GetMapping("/byName/{principalName}")
	public ResponseEntity<?> getPrincipalByName(@PathVariable String principalName) {
		Principal principal = principalService.getPrincipalByName(principalName);
		if (principal != null)// if principal exist
		{
			return new ResponseEntity<>(principal, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/add")
	public ResponseEntity<?> addNewPrincipal(@RequestBody Principal principal) {
		System.out.println("in add principal" + principal);
		try {
			return new ResponseEntity<>(principalService.addNewPrincipal(principal), HttpStatus.CREATED);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/{principalId}")
	public ResponseEntity<?> updatePrincipal(@PathVariable Integer principalId, @RequestBody Principal principal) {
		System.out.println("in update principal" + principal);
		try {
			return new ResponseEntity<>(principalService.updatePrincipal(principalId, principal), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{principalId}")
	public ResponseEntity<?> deletePrincipal(@PathVariable Integer principalId) {

		try {
			return new ResponseEntity<>(principalService.deletePrincipal(principalId), HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
