package com.safeschoolmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.dao.ScheduleDao;
import com.safeschoolmanager.app.entities.Schedule;
import com.safeschoolmanager.app.entities.SchedulePKId;
import com.safeschoolmanager.app.exception.ScheduleException;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleDao scheduleDao;

	public ScheduleServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<Schedule> getAllSchedules() {

		return (List<Schedule>) scheduleDao.findAll();
	}

	@Override
	public Schedule getScheduleById(SchedulePKId schedulepkId) {

		Optional<Schedule> optSchedule = scheduleDao.findById(schedulepkId);
		Schedule schedule = optSchedule
				.orElseThrow(() -> new ScheduleException("Schedule Id " + schedulepkId + " is Invalid !!"));
		return schedule;
	}

	@Override
	public Schedule addNewSchedule(Schedule schedule) {
		return scheduleDao.save(schedule);

	}

	@Override
	public Schedule updateSchedule(SchedulePKId schedulepkId, Schedule schedule) {
		Optional<Schedule> optSchedulefromDb = scheduleDao.findById(schedulepkId);
		Schedule schedulePresent = optSchedulefromDb.orElseThrow(() -> new ScheduleException("Invalid Classroom Id"));
		return scheduleDao.save(schedule);
	}

	@Override
	public Schedule deleteSchedule(SchedulePKId schedulepkId) {
		Optional<Schedule> optSchedulefromDb = scheduleDao.findById(schedulepkId);
		Schedule schedulePresent = optSchedulefromDb.orElseThrow(() -> new ScheduleException("Invalid Classroom Id"));
		scheduleDao.deleteById(schedulepkId);
		return schedulePresent;
	}
}
