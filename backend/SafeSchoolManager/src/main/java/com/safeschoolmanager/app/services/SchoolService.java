package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.School;

public interface SchoolService {

	public List<School> getAllSchools();

	public School getSchoolById(Integer schoolId);

	public School getSchoolByName(String schoolName);

	public School addNewSchool(School school);

	public School updateSchool(Integer schoolId, School school);

	public School deleteSchool(Integer schoolId);
}
