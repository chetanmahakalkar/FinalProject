package com.safeschoolmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.dao.PrincipalDao;
import com.safeschoolmanager.app.entities.Principal;
import com.safeschoolmanager.app.exception.PrincipalException;

@Service
@Transactional
public class PrincipalServiceImpl implements PrincipalService {

	@Autowired
	private PrincipalDao principalDao;

	public PrincipalServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<Principal> getAllPrincipals() {

		return (List<Principal>) principalDao.findAll();
	}

	@Override
	public Principal getPrincipalById(Integer principalId) {

		Optional<Principal> optPrincipal = principalDao.findById(principalId);
		Principal principal = optPrincipal
				.orElseThrow(() -> new PrincipalException("Principal Id " + principalId + " is Invalid !!"));
		return principal;
	}

	@Override
	public Principal getPrincipalByName(String principalName) {

		return principalDao.findByPrincipalName(principalName);// here we have implemented the find by property method
																// in
																// the
																// Principaldao
	}

	@Override
	public Principal addNewPrincipal(Principal principal) {
		return principalDao.save(principal);

	}

	@Override
	public Principal updatePrincipal(Integer principalId, Principal principal) {
		Optional<Principal> optPrincipalfromDb = principalDao.findById(principalId);
		Principal principalPresent = optPrincipalfromDb
				.orElseThrow(() -> new PrincipalException("Invalid Principal Id"));
		return principalDao.save(principal);
	}

	@Override
	public Principal deletePrincipal(Integer principalId) {
		Optional<Principal> optPrincipalfromDb = principalDao.findById(principalId);
		Principal principalPresent = optPrincipalfromDb
				.orElseThrow(() -> new PrincipalException("Invalid Principal Id"));
		principalDao.deleteById(principalId);
		return principalPresent;
	}

}
