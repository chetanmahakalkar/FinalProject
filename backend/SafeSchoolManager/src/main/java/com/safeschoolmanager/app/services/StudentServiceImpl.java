package com.safeschoolmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.dao.StudentDao;
import com.safeschoolmanager.app.entities.Student;
import com.safeschoolmanager.app.exception.StudentException;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	public StudentServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<Student> getAllStudents() {

		return (List<Student>) studentDao.findAll();
	}

	@Override
	public Student getStudentById(Integer studentId) {

		Optional<Student> optStudent = studentDao.findById(studentId);
		Student student = optStudent
				.orElseThrow(() -> new StudentException("Student Id " + studentId + " is Invalid !!"));
		return student;
	}

	@Override
	public Student getStudentByName(String studentName) {

		return studentDao.findByStudentName(studentName);// here we have implemented the find by property method in the
															// Studentdao
	}

	@Override
	public Student addNewStudent(Student student) {
		return studentDao.save(student);

	}

	@Override
	public Student updateStudent(Integer studentId, Student student) {
		Optional<Student> optStudentfromDb = studentDao.findById(studentId);
		Student studentPresent = optStudentfromDb.orElseThrow(() -> new StudentException("Invalid Student Id"));
		return studentDao.save(student);
	}

	@Override
	public Student deleteStudent(Integer studentId) {
		Optional<Student> optStudentfromDb = studentDao.findById(studentId);
		Student studentPresent = optStudentfromDb.orElseThrow(() -> new StudentException("Invalid Student Id"));
		studentDao.deleteById(studentId);
		return studentPresent;
	}
}
