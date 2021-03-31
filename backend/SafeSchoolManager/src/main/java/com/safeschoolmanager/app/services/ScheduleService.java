package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.Schedule;
import com.safeschoolmanager.app.entities.SchedulePKId;

public interface ScheduleService {
	// add Schedule
	public Schedule addNewSchedule(Schedule schedule);

	// get schedule: getAll/getbyId/getByName
	public List<Schedule> getAllSchedules();

	public Schedule getScheduleById(SchedulePKId schedulepkId);

	// update schedule: updateById
	public Schedule updateSchedule(SchedulePKId schedulepkId, Schedule schedule);

	// delete teacher: deleteById
	public Schedule deleteSchedule(SchedulePKId schedulepkId);
}
