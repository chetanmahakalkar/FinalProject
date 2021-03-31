package com.safeschoolmanager.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 5)
	private Integer studentId;
	@Column(nullable = false, length = 30)
	private String studentName;
	@Column(nullable = false, length = 10)
	private LocalDate studentDOB;
	@Column(nullable = false, length = 5)
	private String studentClass;
	@Column(nullable = false, length = 3)
	private String studentSection;
	@Column(unique = true, nullable = false, length = 12)
	private String studentContactNo;
	@Column(unique = true, nullable = false, length = 45)
	private String studentEmail;
	@Column(nullable = false, length = 150)
	private String studentAddress;
	@Column(nullable = false, length = 8)
	private String studentPassword;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School studentForSchool;

	public Student() {
		super();

	}

	public Student(Integer studentId, String studentName, LocalDate studentDOB, String studentClass,
			String studentSection, String studentContactNo, String studentEmail, String studentAddres,
			String studentPassword) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentDOB = studentDOB;
		this.studentClass = studentClass;
		this.studentSection = studentSection;
		this.studentContactNo = studentContactNo;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentPassword = studentPassword;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public LocalDate getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(LocalDate studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public String getStudentContactNo() {
		return studentContactNo;
	}

	public void setStudentContactNo(String studentContactNo) {
		this.studentContactNo = studentContactNo;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddres(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentPassword() {
		return studentPassword;
	}

	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}

	public School getStudentForSchool() {
		return studentForSchool;
	}

	public void setStudentForSchool(School studentForSchool) {
		this.studentForSchool = studentForSchool;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentDOB=" + studentDOB
				+ ", studentClass=" + studentClass + ", studentSection=" + studentSection + ", studentContactNo="
				+ studentContactNo + ", studentEmail=" + studentEmail + ", studentAddres=" + studentAddress
				+ ", studentPassword=" + studentPassword + "]";
	}
}
