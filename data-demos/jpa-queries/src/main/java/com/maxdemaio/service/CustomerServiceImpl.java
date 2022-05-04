package com.maxdemaio.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDTO;
import com.maxdemaio.repository.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	  @Autowired
	  private CustomerRepository  repository; 
	  
	public void insertCustomer(CustomerDTO customer) {
		repository.saveAndFlush(CustomerDTO.prepareCustomerEntity(customer));
		System.out.println("Record added successfully");
	}

	@Override
	public Iterable<Customer> getCustomer(String address) {
		
		return repository.findByAddress(address);
	}
	
	
}
