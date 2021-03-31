package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

	public Student findByStudentName(String studentName);

}
