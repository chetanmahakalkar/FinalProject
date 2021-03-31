package com.safeschoolmanager.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.entities.Teacher;
import com.safeschoolmanager.app.entities.TeacherPKId;
import com.safeschoolmanager.app.exception.TeacherException;
import com.safeschoolmanager.app.services.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDao teacherDao;

	public TeacherServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<Teacher> getAllTeachers() {

		return (List<Teacher>) teacherDao.findAll();
	}

	@Override
	public Teacher getTeacherById(TeacherPKId teacherId) {

		Optional<Teacher> optTeacher = teacherDao.findById(teacherId);
		Teacher teacher = optTeacher
				.orElseThrow(() -> new TeacherException("Teacher Id " + teacherId + " is Invalid !!"));
		return teacher;
	}

	@Override
	public Teacher getTeacherByName(String teacherName) {

		return teacherDao.findByTeacherName(teacherName);// here we have implemented the find by property method in the
		// Teacherdao
	}

	@Override
	public Teacher addNewTeacher(Teacher teacher) {
		return teacherDao.save(teacher);

	}

	@Override
	public Teacher updateTeacher(TeacherPKId teacherId, Teacher teacher) {
		Optional<Teacher> optTeacherfromDb = teacherDao.findById(teacherId);
		Teacher teacherPresent = optTeacherfromDb.orElseThrow(() -> new TeacherException("Invalid Teacher Id"));
		return teacherDao.save(teacher);
	}

	@Override
	public Teacher deleteTeacher(TeacherPKId teacherId) {
		Optional<Teacher> optTeacherfromDb = teacherDao.findById(teacherId);
		Teacher teacherPresent = optTeacherfromDb.orElseThrow(() -> new TeacherException("Invalid Teacher Id"));
		teacherDao.deleteById(teacherId);
		return teacherPresent;
	}
}
