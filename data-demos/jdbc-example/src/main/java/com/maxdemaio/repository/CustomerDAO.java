package com.maxdemaio.repository;

import com.maxdemaio.entity.Customer;

public interface CustomerDAO {
    // Method to insert a Customer record into the db
    public void insert(Customer customer);

    // Method to remove a Customer record from the db
    public int remove(Long phoneNo);
}
