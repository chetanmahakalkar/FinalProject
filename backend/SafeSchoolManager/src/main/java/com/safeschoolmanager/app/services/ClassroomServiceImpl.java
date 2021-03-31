package com.safeschoolmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.dao.ClassroomDao;
import com.safeschoolmanager.app.entities.Classroom;
import com.safeschoolmanager.app.entities.ClassroomPKId;
import com.safeschoolmanager.app.exception.ClassroomException;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassroomService {
	@Autowired
	private ClassroomDao classroomDao;

	public ClassroomServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<Classroom> getAllClassrooms() {

		return (List<Classroom>) classroomDao.findAll();
	}

	@Override
	public Classroom getClassroomById(ClassroomPKId classroompkId) {

		Optional<Classroom> optClassroom = classroomDao.findById(classroompkId);
		Classroom classroom = optClassroom
				.orElseThrow(() -> new ClassroomException("Classroom Id " + classroompkId + " is Invalid !!"));
		return classroom;
	}

	@Override
	public Classroom addNewClassroom(Classroom classroom) {
		return classroomDao.save(classroom);

	}

	@Override
	public Classroom updateClassroom(ClassroomPKId classroompkId, Classroom classroom) {
		Optional<Classroom> optClassroomfromDb = classroomDao.findById(classroompkId);
		Classroom classroomPresent = optClassroomfromDb
				.orElseThrow(() -> new ClassroomException("Invalid Classroom Id"));
		return classroomDao.save(classroom);
	}

	@Override
	public Classroom deleteClassroom(ClassroomPKId classroompkId) {
		Optional<Classroom> optClassroomfromDb = classroomDao.findById(classroompkId);
		Classroom classroomPresent = optClassroomfromDb
				.orElseThrow(() -> new ClassroomException("Invalid Classroom Id"));
		classroomDao.deleteById(classroompkId);
		return classroomPresent;
	}
}
