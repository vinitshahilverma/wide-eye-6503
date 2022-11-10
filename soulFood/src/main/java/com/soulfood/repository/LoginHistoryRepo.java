package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soulfood.model.LoginHistory;

@Repository
public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Integer> {

}
