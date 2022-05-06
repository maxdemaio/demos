package com.maxdemaio.service;

import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDto;
import com.maxdemaio.exception.JpaQueriesException;
import com.maxdemaio.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository mockCustomerRepository;

    private CustomerServiceImpl customerService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks((this));
        customerService = new CustomerServiceImpl(mockCustomerRepository);
    }

    @Test
    void test_insertCustomer() throws JpaQueriesException {
        // Given
        CustomerDto testCustomer = new CustomerDto(7022713754L, "Test", 20, 'M', "Canton", 1);

        // When (void)
        when(mockCustomerRepository.saveAndFlush(any(Customer.class))).thenReturn(null);

        // Then
        CustomerDto actual = customerService.insertCustomer(testCustomer);
        assertEquals(testCustomer, actual);
    }

    @Test
    void test_insertCustomer_failure_on_validate() throws JpaQueriesException {
        // Given
        String invalidName = StringUtils.repeat("x", 40);
        CustomerDto testCustomer = new CustomerDto(7022713754L, invalidName, 20, 'M', "Canton", 1);

        // Then
        assertThrows(JpaQueriesException.class, () -> customerService.insertCustomer(testCustomer));
    }
}
