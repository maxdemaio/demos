package com.maxdemaio.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDto;
import com.maxdemaio.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    public void insertCustomer(CustomerDto customer) {
        repository.saveAndFlush(CustomerDto.prepareCustomerEntity(customer));
        System.out.println("Record added successfully");
    }

    @Override
    public List<CustomerDto> getCustomersByAddress(String address) {
        List<Customer> customers = repository.findByAddress(address);
        List<CustomerDto> custDtos = new ArrayList<>();
        for (Customer c : customers) {
            CustomerDto custDto = c.prepareDTO(c);
            custDtos.add(custDto);
        }
        return custDtos;
    }


}
