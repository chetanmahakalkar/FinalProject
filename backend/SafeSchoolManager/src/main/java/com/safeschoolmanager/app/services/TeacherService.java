package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.Teacher;
import com.safeschoolmanager.app.entities.TeacherPKId;

public interface TeacherService {
	// add Teacher
	public Teacher addNewTeacher(Teacher teacher);

	// get teacher: getAll/getbyId/getByName
	public List<Teacher> getAllTeachers();

	public Teacher getTeacherById(TeacherPKId teacherpkId);

	public Teacher getTeacherByName(String teacherName);

	// update teacher: updateById
	public Teacher updateTeacher(TeacherPKId teacherpkId, Teacher teacher);

	// delete teacher: deleteById
	public Teacher deleteTeacher(TeacherPKId teacherpkId);
}
