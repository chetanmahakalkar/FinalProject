package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.Teacher;
import com.safeschoolmanager.app.entities.TeacherPKId;

public interface TeacherDao extends JpaRepository<Teacher, TeacherPKId> {

	public Teacher findByTeacherName(String teacherName);

}
