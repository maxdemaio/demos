package com.maxdemaio.service;


import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDTO;

public interface CustomerService {

	public void insertCustomer(CustomerDTO customer) ;

	public Iterable<Customer> getCustomer(String address);

}