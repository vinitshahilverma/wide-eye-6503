package com.soulfood.repository;

import com.soulfood.model.Address;
import com.soulfood.model.CurrentUserSession;
import com.soulfood.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    @Query ("from Customer c where c.firstName=?1 and c.lastName=?2 and c.mobileNumber=?3 and c.email=?4")
    public Customer findCustomer(String firstName, String lastName,String mobileNumber, String email);

    public Customer getById(Integer customerId);

    public Optional<Customer> findByMobileNumber(String string);

    public Optional<CurrentUserSession> findByCustomerId(Integer customerId1);

    public Optional<Customer> findByMobileNumberAndPassword(Long mobileNo,String password);
}
