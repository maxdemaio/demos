package com.maxdemaio.service;
import com.maxdemaio.dto.CustomerDTO;
import com.maxdemaio.repository.CustomerDAO;
import com.maxdemaio.repository.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public void insert(CustomerDTO customer) {
        customerDAO.insert(CustomerDTO.prepareCustomerEntity(customer));
    }
    @Override
    public int remove(Long phoneNo) {
        return customerDAO.remove(phoneNo);

    }
}
