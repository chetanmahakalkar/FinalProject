package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

	public Admin findByAdminName(String adminName);

	// public Optional<Admin> findByEmailAndPassword(String adminEmail, String
	// adminPassword);

}
