package com.safeschoolmanager.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 5)
	private Integer schoolID;
	@Column(unique = true, nullable = false, length = 30)
	private String schoolName;
	@Column(nullable = false, length = 150)
	private String schoolAddress;
	@Column(unique = true, nullable = false, length = 12)
	private String schoolContactNo;
	@Column(unique = true, nullable = false, length = 40)
	private String schoolEmail;

	@JsonBackReference // this annotation helps prevent infinite recursionoccurance during the methods
						// call

	@OneToMany(mappedBy = "enrolledSchool")
	private List<Admin> adminList = new ArrayList<>();

	@OneToMany(mappedBy = "scheduleForSchool")
	private List<Schedule> scheduleList = new ArrayList<>();

	@OneToOne(mappedBy = "principalForSchool")
	private Principal principalOfSchool;

	@OneToMany(mappedBy = "teacherForSchool")
	private List<Teacher> teacherList = new ArrayList<>();

	@OneToMany(mappedBy = "studentForSchool")
	private List<Student> studentList = new ArrayList<>();

	public School() {
		System.out.println("In the course const");

	}

	public School(String schoolName, String schoolAddress, String schoolContactNo, String schoolEmail) {
		super();
		this.schoolName = schoolName;
		this.schoolAddress = schoolAddress;
		this.schoolContactNo = schoolContactNo;
		this.schoolEmail = schoolEmail;
	}

	public Integer getSchoolID() {
		return schoolID;
	}

	public void setSchoolID(Integer schoolID) {
		this.schoolID = schoolID;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getSchoolContactNo() {
		return schoolContactNo;
	}

	public void setSchoolContactNo(String schoolContactNo) {
		this.schoolContactNo = schoolContactNo;
	}

	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}

	public String getSchoolEmail() {
		return schoolEmail;
	}

	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail;
	}

	@Override
	public String toString() {
		return "School [schoolID=" + schoolID + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress
				+ ", schoolContactNo=" + schoolContactNo + ", schoolEmail=" + schoolEmail + "]";
	}

}
