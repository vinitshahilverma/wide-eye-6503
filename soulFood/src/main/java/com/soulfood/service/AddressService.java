package com.soulfood.service;

import com.soulfood.repository.AddressRepo;
import com.soulfood.model.Address;

public interface AddressService {

    public Address addAddress (Address address);

    public Address updateAddress (Address address);

    public Address removeAddress (Address address);

    public Address viewAddress (Address address);
}
