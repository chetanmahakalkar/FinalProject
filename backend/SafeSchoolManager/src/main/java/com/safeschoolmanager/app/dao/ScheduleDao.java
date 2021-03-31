package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.Schedule;
import com.safeschoolmanager.app.entities.SchedulePKId;

public interface ScheduleDao extends JpaRepository<Schedule, SchedulePKId> {

}
