package com.safeschoolmanager.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Principal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, length = 5)
	private Integer principalId;
	@Column(nullable = false, length = 30)
	private String principalName;
	@Column(nullable = false, length = 10)
	private LocalDate principalDOB;
	@Column(unique = true, nullable = false, length = 12)
	private String principalContactNo;
	@Column(unique = true, nullable = false, length = 45)
	private String principalEmail;
	@Column(nullable = false, length = 150)
	private String principalAddress;
	@Column(length = 30)
	private String principalSME;
	@Column(nullable = false, length = 8)
	private String principalPassword;
	@OneToOne
	@JoinColumn(name = "school_id")
	private School principalForSchool;

	public Integer getPrincipalId() {
		return principalId;
	}

	public void setPrincipalId(Integer principalId) {
		this.principalId = principalId;
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public LocalDate getPrincipalDOB() {
		return principalDOB;
	}

	public void setPrincipalDOB(LocalDate principalDOB) {
		this.principalDOB = principalDOB;
	}

	public String getPrincipalContactNo() {
		return principalContactNo;
	}

	public void setPrincipalContactNo(String principalContactNo) {
		this.principalContactNo = principalContactNo;
	}

	public String getPrincipalEmail() {
		return principalEmail;
	}

	public void setPrincipalEmail(String principalEmail) {
		this.principalEmail = principalEmail;
	}

	public String getPrincipalAddress() {
		return principalAddress;
	}

	public void setPrincipalAddress(String principalAddress) {
		this.principalAddress = principalAddress;
	}

	public String getPrincipalSME() {
		return principalSME;
	}

	public void setPrincipalSME(String principalSME) {
		this.principalSME = principalSME;
	}

	public String getPrincipalPassword() {
		return principalPassword;
	}

	public void setPrincipalPassword(String principalPassword) {
		this.principalPassword = principalPassword;
	}

	public School getPrincipalForSchool() {
		return principalForSchool;
	}

	public void setPrincipalForSchool(School principalForSchool) {
		this.principalForSchool = principalForSchool;
	}
}
