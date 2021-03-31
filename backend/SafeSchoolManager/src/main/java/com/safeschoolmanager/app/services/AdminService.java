package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.Admin;

public interface AdminService {

//add admin 
	public Admin addNewAdmin(Admin admin);

// get admin: getAll/getbyId/getByName
	public List<Admin> getAllAdmins();

	public Admin getAdminById(Integer adminId);

	public Admin getAdminByName(String adminName);

//update admin: updateById
	public Admin updateAdmin(Integer adminId, Admin admin);

//delete admin: deleteById
	public Admin deleteAdmin(Integer adminId);

	// login admin:login by email and password
	// public Admin findByEmailAndPassword(String adminEmail, String adminPassword);
}
