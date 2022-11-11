package com.soulfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soulfood.model.Admin;
import com.soulfood.model.Customer;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

	@Query("from Admin a where a.customer.customerId=?1")
	public Admin findCustomerIdIfExist(Integer customerId);
	
}