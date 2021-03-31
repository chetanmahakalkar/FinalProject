package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.Classroom;
import com.safeschoolmanager.app.entities.ClassroomPKId;

public interface ClassroomDao extends JpaRepository<Classroom, ClassroomPKId> {

}
