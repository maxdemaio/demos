package com.maxdemaio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDTO;
import com.maxdemaio.service.CustomerService;

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
		CustomerDTO customer1= new CustomerDTO(7022713754L, "Adam", 27, 'M', "Calgary", 1);
		CustomerDTO customer2= new CustomerDTO(7022713744L, "Susan", 27, 'F', "Alberta", 2);
		CustomerDTO customer3= new CustomerDTO(7022713745L, "Andrew", 27, 'M', "Chicago", 2);
		
		//invoke service layer method to insert Customer
		service.insertCustomer(customer1);
		service.insertCustomer(customer2);
		service.insertCustomer(customer3);
		
		Iterable<Customer> cus = service.getCustomer("Chicago");

		for (Customer alist : cus) {
			System.out.println(alist);
		}
		
	}

}
