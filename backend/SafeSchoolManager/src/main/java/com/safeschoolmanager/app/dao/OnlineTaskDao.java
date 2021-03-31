package com.safeschoolmanager.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeschoolmanager.app.entities.OnlineTask;

public interface OnlineTaskDao extends JpaRepository<OnlineTask, Integer> {

}
