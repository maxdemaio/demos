package com.maxdemaio.service.validator;

import com.maxdemaio.dto.CustomerDto;
import com.maxdemaio.exception.JpaQueriesException;

public class CustomerDtoValidator {
    public static void validateCustomer(CustomerDto custDto) throws JpaQueriesException {
        isValidName(custDto.getName());
        isValidPhoneNum(custDto.getPhoneNumber());
    }

    public static void isValidName(String name) throws JpaQueriesException {
        if (name.length() > 39)
            throw new JpaQueriesException("CustomerDtoValidator.INVALID_CUST_NAME");
        return;
    }

    public static void isValidPhoneNum(Long phoneNum) throws JpaQueriesException {
        // No more than 15 digits
        if (phoneNum >= 1000000000000000.0)
            throw new JpaQueriesException("CustomerDtoValidator.INVALID_CUST_PHONE");
        return;
    }

}
