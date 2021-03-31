package com.safeschoolmanager.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 5)
	private Integer adminID;
	@Column(unique = true, nullable = false, length = 30)
	private String adminName;
	@Column(nullable = false, length = 10)
	private LocalDate adminDOB;
	@Column(nullable = false, length = 150)
	private String adminAddress;
	@Column(unique = true, nullable = false, length = 12)
	private String adminContactNo;
	@Column(nullable = false, unique = true, length = 45)
	private String adminEmail;
	@Column(nullable = false, length = 8)
	private String adminPassword;

	@ManyToOne
	@JoinColumn(name = "id_school")
	private School enrolledSchool;

	public Admin() {
		System.out.println("In admin constr");

	}

	public Admin(String adminName, LocalDate adminDOB, String adminAddress, String adminContactNo, String adminEmail,
			String adminPassword) {
		super();
		this.adminName = adminName;
		this.adminDOB = adminDOB;
		this.adminAddress = adminAddress;
		this.adminContactNo = adminContactNo;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public LocalDate getAdminDOB() {
		return adminDOB;
	}

	public void setAdminDOB(LocalDate adminDOB) {
		this.adminDOB = adminDOB;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public String getAdminContactNo() {
		return adminContactNo;
	}

	public void setAdminContactNo(String adminContactNo) {
		this.adminContactNo = adminContactNo;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public School getEnrolledSchool() {
		return enrolledSchool;
	}

	public void setEnrolledSchool(School enrolledSchool) {
		this.enrolledSchool = enrolledSchool;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", adminName=" + adminName + ", adminDOB=" + adminDOB + ", adminAddress="
				+ adminAddress + ", adminContactNo=" + adminContactNo + ", adminEmail=" + adminEmail
				+ ", adminPassword=" + adminPassword + "]";
	}

}
