package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

	// extra functions which are not provided bt thejpa repositories but we wanted
	// are declared and defined here in DAO layer

	// the find by property is implemented
	public School findBySchoolName(String schoolName);

}
