package com.maxdemaio.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maxdemaio.domain.Customer;
import com.maxdemaio.dto.CustomerDto;
import com.maxdemaio.exception.JpaQueriesException;
import com.maxdemaio.repository.CustomerRepository;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private CustomerRepository mockCustomerRepository;

    private CustomerServiceImpl customerService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks((this));
        customerService = new CustomerServiceImpl(mockCustomerRepository);
    }

    @Test
    void test_insertCustomer() throws JpaQueriesException, JsonProcessingException, JSONException {
        // Given
        CustomerDto testCustomerDto = new CustomerDto(7022713754L, "Test", 20, 'M', "Canton", 1);

        // When (void)
        when(mockCustomerRepository.saveAndFlush(any(Customer.class))).thenReturn(null);

        // Then
        // Compare JSON string values of POJOs
        CustomerDto actual = customerService.insertCustomer(testCustomerDto);
        JSONAssert.assertEquals(objectMapper.writeValueAsString(testCustomerDto), objectMapper.writeValueAsString(actual), JSONCompareMode.NON_EXTENSIBLE);
    }

    @Test
    void test_getCustomer() throws JpaQueriesException, JsonProcessingException, JSONException {
        // Given
        Customer testCustomer = new Customer(7022713754L, "Test", 20, 'M', "Canton", 1);
        CustomerDto testCustomerDto = new CustomerDto(7022713754L, "Test", 20, 'M', "Canton", 1);

        // When
        when(mockCustomerRepository.findById(any(Long.class))).thenReturn(Optional.of(testCustomer));

        // Then
        CustomerDto actual = customerService.getCustomer(testCustomerDto.getPhoneNumber());
        JSONAssert.assertEquals(objectMapper.writeValueAsString(testCustomerDto), objectMapper.writeValueAsString(actual), JSONCompareMode.NON_EXTENSIBLE);
    }

    @Test
    void test_getCustomer_failure_on_validate() throws JpaQueriesException, JsonProcessingException, JSONException {
        // Given
        Long invalidPhoneNo = 1000000000000000L;

        // Then
        assertThrows(JpaQueriesException.class, () -> customerService.getCustomer(invalidPhoneNo));
    }

    @Test
    void test_insertCustomer_failure_on_validate() throws JpaQueriesException {
        // Given
        String invalidName = StringUtils.repeat("x", 40);
        CustomerDto testCustomerDto = new CustomerDto(7022713754L, invalidName, 20, 'M', "Canton", 1);

        // Then
        assertThrows(JpaQueriesException.class, () -> customerService.insertCustomer(testCustomerDto));
    }
}
