package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.Classroom;
import com.safeschoolmanager.app.entities.ClassroomPKId;

public interface ClassroomService {

	// add Classroom
	public Classroom addNewClassroom(Classroom classroom);

	// get classroom: getAll/getbyId
	public List<Classroom> getAllClassrooms();

	public Classroom getClassroomById(ClassroomPKId classroompkId);

	// update classroom: updateById
	public Classroom updateClassroom(ClassroomPKId classroompkId, Classroom classroom);

	// delete teacher: deleteById
	public Classroom deleteClassroom(ClassroomPKId classroompkId);

}
