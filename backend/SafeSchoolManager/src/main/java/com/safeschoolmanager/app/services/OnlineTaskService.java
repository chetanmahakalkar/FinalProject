package com.safeschoolmanager.app.services;

import java.util.List;

import com.safeschoolmanager.app.entities.OnlineTask;

public interface OnlineTaskService {
	// add onlineTask
	public OnlineTask addNewOnlineTask(OnlineTask onlineTask);

	// get onlineTask: getAll/getbyId
	public List<OnlineTask> getAllOnlineTasks();

	public OnlineTask getOnlineTaskById(Integer onlineTaskId);

	// update onlineTask: updateById
	public OnlineTask updateOnlineTask(Integer onlineTaskId, OnlineTask onlineTask);

	// delete onlineTask: deleteById
	public OnlineTask deleteOnlineTask(Integer onlineTaskId);

}
