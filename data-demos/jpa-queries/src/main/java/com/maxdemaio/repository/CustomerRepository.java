package com.maxdemaio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxdemaio.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	List<Customer> findByAddress(String address);
}
