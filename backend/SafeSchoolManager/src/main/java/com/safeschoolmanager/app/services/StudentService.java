package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.Student;

public interface StudentService {
	// add student
	public Student addNewStudent(Student student);

	// get student: getAll/getbyId/getByName
	public List<Student> getAllStudents();

	public Student getStudentById(Integer studentId);

	public Student getStudentByName(String studentName);

	// update student: updateById
	public Student updateStudent(Integer studentId, Student student);

	// delete student: deleteById
	public Student deleteStudent(Integer studentId);
}
