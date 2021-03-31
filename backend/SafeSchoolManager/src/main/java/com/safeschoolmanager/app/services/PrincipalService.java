package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.Principal;

public interface PrincipalService {
	// add principal
	public Principal addNewPrincipal(Principal principal);

	// get principal: getAll/getbyId/getByName
	public List<Principal> getAllPrincipals();

	public Principal getPrincipalById(Integer principalId);

	public Principal getPrincipalByName(String principalName);

	// update principal: updateById
	public Principal updatePrincipal(Integer principalId, Principal principal);

	// delete principal: deleteById
	public Principal deletePrincipal(Integer principalId);
}
