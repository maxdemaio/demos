package com.maxdemaio;

import com.maxdemaio.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.maxdemaio.dto.CustomerDto;
import com.maxdemaio.service.CustomerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Client implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    @Autowired
    CustomerService service;

    public static void main(String[] args) {
        SpringApplication.run(Client.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CustomerDto customer1 = new CustomerDto(7022713754L, "Adam", 27, 'M', "Calgary", 1);
        CustomerDto customer2 = new CustomerDto(7022713744L, "Susan", 27, 'F', "Alberta", 2);
        CustomerDto customer3 = new CustomerDto(7022713745L, "Andrew", 27, 'M', "Chicago", 2);

        //invoke service layer method to insert Customer
//		service.insertCustomer(customer1);
//		service.insertCustomer(customer2);
//		service.insertCustomer(customer3);

        List<CustomerDto> custDtos = service.getCustomersByAddress("Chicago");

        for (CustomerDto c : custDtos) {
            System.out.println(c);
        }

        Pageable pageable = PageRequest.of(0, 2);
        System.out.println("First page of records are: ");
        Iterable<Customer> custPage = service.findAll(pageable);
        for (Customer c : custPage) {
            System.out.println(c);
        }

        System.out.println("Sorted records..");
        Iterable<Customer> custList = service.findAll(Sort.by(Sort.Direction.DESC, "name"));
        for (Customer c : custList) {
            System.out.println(c);
        }

    }

}
