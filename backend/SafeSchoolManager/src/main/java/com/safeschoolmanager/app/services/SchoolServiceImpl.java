package com.safeschoolmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.dao.SchoolDao;
import com.safeschoolmanager.app.entities.School;
import com.safeschoolmanager.app.exception.SchoolException;

@Service
@Transactional
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolDao schoolDao;

	public SchoolServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<School> getAllSchools() {

		return schoolDao.findAll();
	}

	@Override
	public School getSchoolById(Integer schoolId) {

		Optional<School> optSchool = schoolDao.findById(schoolId);
		School school = optSchool.orElseThrow(() -> new SchoolException("School Id " + schoolId + " is Invalid !!"));
		return school;
	}

	@Override
	public School getSchoolByName(String schoolName) {

		return schoolDao.findBySchoolName(schoolName);// here we have implemented the find by property method in the
														// schooldao
	}

	@Override
	public School addNewSchool(School school) {
		return schoolDao.save(school);

	}

	@Override
	public School updateSchool(Integer schoolId, School school) {
		Optional<School> optSchoolfromDb = schoolDao.findById(schoolId);
		School schoolPresent = optSchoolfromDb.orElseThrow(() -> new SchoolException("Invalid School Id"));
		return schoolDao.save(school);
	}

	@Override
	public School deleteSchool(Integer schoolId) {
		Optional<School> optSchoolfromDb = schoolDao.findById(schoolId);
		School schoolPresent = optSchoolfromDb.orElseThrow(() -> new SchoolException("Invalid School Id"));
		schoolDao.deleteById(schoolId);
		return schoolPresent;
	}

}
