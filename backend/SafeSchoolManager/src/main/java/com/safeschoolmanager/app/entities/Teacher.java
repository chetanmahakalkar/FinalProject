package com.safeschoolmanager.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@IdClass(TeacherPKId.class)
public class Teacher {
	@Id
	@Column(nullable = false, length = 30)
	private String teacherName;
	@Id
	@Column(nullable = false, length = 30)
	private String teacherSME;
	@Column(nullable = false, length = 10)
	private LocalDate teacherDOB;
	@Column(unique = true, nullable = false, length = 12)
	private String teacherContactNo;
	@Column(nullable = false, unique = true, length = 45)
	private String teacherEmail;
	@Column(nullable = false, length = 150)
	private String teacherAddress;
	@Column(nullable = false, length = 8)
	private String teacherPassword;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School teacherForSchool;
	@OneToOne
	@JoinColumns({ @JoinColumn(name = "class_assigned", referencedColumnName = "classroom"),
			@JoinColumn(name = "section_assigned", referencedColumnName = "section") })
	private Classroom class_teacher;

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSME() {
		return teacherSME;
	}

	public void setTeacherSME(String teacherSME) {
		this.teacherSME = teacherSME;
	}

	public LocalDate getTeacherDOB() {
		return teacherDOB;
	}

	public void setTeacherDOB(LocalDate teacherDOB) {
		this.teacherDOB = teacherDOB;
	}

	public String getTeacherContactNo() {
		return teacherContactNo;
	}

	public void setTeacherContactNo(String teacherContactNo) {
		this.teacherContactNo = teacherContactNo;
	}

	public String getTeacherEmail() {
		return teacherEmail;
	}

	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}

	public String getTeacherAddress() {
		return teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public School getTeacherForSchool() {
		return teacherForSchool;
	}

	public void setTeacherForSchool(School teacherForSchool) {
		this.teacherForSchool = teacherForSchool;
	}

	public Classroom getClass_teacher() {
		return class_teacher;
	}

	public void setClass_teacher(Classroom class_teacher) {
		this.class_teacher = class_teacher;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	@Override
	public String toString() {
		return "Teacher [teacherName=" + teacherName + ", teacherSME=" + teacherSME + ", teacherDOB=" + teacherDOB
				+ ", teacherContactNo=" + teacherContactNo + ", teacherEmail=" + teacherEmail + ", teacherAddress="
				+ teacherAddress + ", teacherPassword=" + teacherPassword + "]";
	}

}