package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.Principal;

public interface PrincipalDao extends JpaRepository<Principal, Integer> {

	public Principal findByPrincipalName(String principalName);

}
