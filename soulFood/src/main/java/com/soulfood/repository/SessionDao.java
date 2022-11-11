package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soulfood.model.CurrentUserSession;

public interface SessionDao extends JpaRepository<CurrentUserSession, Integer> {

	
	public  CurrentUserSession  findByUuid(String uuid);
}
