package com.maxdemaio.service;


import com.maxdemaio.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    public void insertCustomer(CustomerDto customer);

    public List<CustomerDto> getCustomersByAddress(String address);
}