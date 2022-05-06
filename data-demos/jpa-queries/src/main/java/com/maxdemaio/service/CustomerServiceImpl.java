package com.maxdemaio.service;


import com.maxdemaio.exception.JpaQueriesException;
import com.maxdemaio.service.validator.CustomerDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDto;
import com.maxdemaio.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerDto insertCustomer(CustomerDto customer) throws JpaQueriesException {
        CustomerDtoValidator.validateCustomer(customer);
        repository.saveAndFlush(CustomerDto.prepareCustomerEntity(customer));
        System.out.println("Record added successfully");
        return customer;
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

    @Override
    public CustomerDto getCustomer(Long phoneNo) throws JpaQueriesException {
        CustomerDtoValidator.isValidPhoneNum(phoneNo);
        Optional<Customer> optionalCust = repository.findById(phoneNo);
        Customer custEntity = optionalCust.get();
        CustomerDto custDto = Customer.prepareDTO(custEntity);
        return custDto;
    }

    @Override
    public void removeCustomer(Long phoneNo) throws JpaQueriesException {
        CustomerDtoValidator.isValidPhoneNum(phoneNo);
        repository.deleteById(phoneNo);
        return;
    }

    @Override
    public String updateCustomer(Long phoneNo, Integer newPlanId) throws JpaQueriesException {
        CustomerDtoValidator.isValidPhoneNum(phoneNo);
        Optional<Customer> optionalCust = repository.findById(phoneNo);
        Customer custEntity = optionalCust.get();
        custEntity.setPlanId(newPlanId);
        repository.save(custEntity);
        CustomerDto custDto = Customer.prepareDTO(custEntity);
        return "The plan for customer w/ phone number: " + phoneNo + " has been updated successfully";
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll(Sort sort) {
        return repository.findAll(sort);
    }


}
