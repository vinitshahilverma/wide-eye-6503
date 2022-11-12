package com.soulfood.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.soulfood.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepositoryImplementation<Customer, Integer>{

	public Customer findByEmail(String email);
	
}
