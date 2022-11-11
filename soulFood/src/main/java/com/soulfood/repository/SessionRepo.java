package com.soulfood.repository;

import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulfood.model.CurrentUserSession;


@Repository
public interface SessionRepo extends JpaRepository<CurrentUserSession, Integer>{
	
	public Optional<CurrentUserSession> findByCustomerId(Integer customerId);
	
	public Optional<CurrentUserSession> findByUuid(String uuid);

}
