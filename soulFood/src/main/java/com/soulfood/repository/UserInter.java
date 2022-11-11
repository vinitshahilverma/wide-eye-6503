package com.soulfood.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulfood.model.User;

@Repository
public interface UserInter extends JpaRepository<User, Integer> {

	public Optional<User> findByUserNameAndUserPassword(String userName, String password);
	
}
