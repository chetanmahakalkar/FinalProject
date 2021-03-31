package com.safeschoolmanager.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safeschoolmanager.app.dao.OnlineTaskDao;
import com.safeschoolmanager.app.entities.OnlineTask;
import com.safeschoolmanager.app.exception.OnlineTaskException;

@Service
@Transactional
public class OnlineTaskServiceImpl implements OnlineTaskService {

	@Autowired
	private OnlineTaskDao onlineTaskDao;

	public OnlineTaskServiceImpl() {
		System.out.println("in constructor of" + getClass().getName());
	}

	public List<OnlineTask> getAllOnlineTasks() {

		return (List<OnlineTask>) onlineTaskDao.findAll();
	}

	@Override
	public OnlineTask getOnlineTaskById(Integer onlineTaskId) {

		Optional<OnlineTask> optOnlineTask = onlineTaskDao.findById(onlineTaskId);
		OnlineTask onlineTask = optOnlineTask
				.orElseThrow(() -> new OnlineTaskException("OnlineTask Id " + onlineTaskId + " is Invalid !!"));
		return onlineTask;
	}

	@Override
	public OnlineTask addNewOnlineTask(OnlineTask onlineTask) {
		return onlineTaskDao.save(onlineTask);

	}

	@Override
	public OnlineTask updateOnlineTask(Integer onlineTaskId, OnlineTask onlineTask) {
		Optional<OnlineTask> optOnlineTaskfromDb = onlineTaskDao.findById(onlineTaskId);
		OnlineTask onlineTaskPresent = optOnlineTaskfromDb
				.orElseThrow(() -> new OnlineTaskException("Invalid OnlineTask Id"));
		return onlineTaskDao.save(onlineTask);
	}

	@Override
	public OnlineTask deleteOnlineTask(Integer onlineTaskId) {
		Optional<OnlineTask> optOnlineTaskfromDb = onlineTaskDao.findById(onlineTaskId);
		OnlineTask onlineTaskPresent = optOnlineTaskfromDb
				.orElseThrow(() -> new OnlineTaskException("Invalid OnlineTask Id"));
		onlineTaskDao.deleteById(onlineTaskId);
		return onlineTaskPresent;
	}
}
