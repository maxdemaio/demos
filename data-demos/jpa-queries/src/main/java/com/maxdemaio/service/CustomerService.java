package com.maxdemaio.service;


import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDto;
import com.maxdemaio.exception.JpaQueriesException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CustomerService {

    public CustomerDto insertCustomer(CustomerDto customer) throws JpaQueriesException;

    public List<CustomerDto> getCustomersByAddress(String address);

    public CustomerDto getCustomer(Long phoneNo) throws JpaQueriesException;

    public void removeCustomer(Long phoneNo) throws JpaQueriesException;

    public String updateCustomer(Long phoneNo, Integer newPlanId) throws JpaQueriesException;

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll(Sort sort);
}