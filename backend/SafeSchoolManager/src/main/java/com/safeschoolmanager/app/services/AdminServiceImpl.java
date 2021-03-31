package com.safeschoolmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.dao.AdminDao;
import com.safeschoolmanager.app.entities.Admin;
import com.safeschoolmanager.app.exception.AdminException;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	public AdminServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<Admin> getAllAdmins() {

		return (List<Admin>) adminDao.findAll();
	}

	@Override
	public Admin getAdminById(Integer adminId) {

		Optional<Admin> optAdmin = adminDao.findById(adminId);
		Admin admin = optAdmin.orElseThrow(() -> new AdminException("Admin Id " + adminId + " is Invalid !!"));
		return admin;
	}

	@Override
	public Admin getAdminByName(String adminName) {

		return adminDao.findByAdminName(adminName);// here we have implemented the find by property method in the
													// Admindao
	}

	@Override
	public Admin addNewAdmin(Admin admin) {
		return adminDao.save(admin);

	}

	@Override
	public Admin updateAdmin(Integer adminId, Admin admin) {
		Optional<Admin> optAdminfromDb = adminDao.findById(adminId);
		Admin adminPresent = optAdminfromDb.orElseThrow(() -> new AdminException("Invalid Admin Id"));
		return adminDao.save(admin);
	}

	@Override
	public Admin deleteAdmin(Integer adminId) {
		Optional<Admin> optAdminfromDb = adminDao.findById(adminId);
		Admin adminPresent = optAdminfromDb.orElseThrow(() -> new AdminException("Invalid Admin Id"));
		adminDao.deleteById(adminId);
		return adminPresent;
	}

//	@Override
//	public Admin findByEmailAndPassword(String adminEmail, String adminPassword) {
//		Optional<Admin> optAdminfromDb = adminDao.findByEmailAndPassword(adminEmail, adminPassword);
//		Admin adminPresent = optAdminfromDb.orElseThrow(() -> new AdminException("Invalid Admin Id..!!!"));
//
//		return null;
//	}

}
