package com.soulfood.service;

import com.soulfood.repository.AddressRepo;
import com.soulfood.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepo addressDao;


    @Override
    public Address addAddress(Address address) {
        addressDao.save(address);
        return address;
    }

    @Override
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    public Address removeAddress(Address address) {
        return null;
    }

    @Override
    public Address viewAddress(Address address) {
        return null;
    }
}
