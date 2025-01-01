package com.bankapp;

import com.bankapp.dto.request.CustomerLoginRequest;
import com.bankapp.dto.request.CustomerSignUpRequest;
import com.bankapp.dto.request.ForgetPasswordRequest;
import com.bankapp.dto.response.CustomerLoginResponse;
import com.bankapp.dto.response.CustomerSignUpResponse;
import com.bankapp.dto.response.ForgetPasswordResponse;
import com.bankapp.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BankAppApplicationTests {

    @Autowired
    CustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
    void testForCustomerToSignup() {
        CustomerSignUpRequest request = new CustomerSignUpRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setUserName("john123");
        request.setEmail("2ceeishere@gmail.com");
        request.setPassword("1234");
        request.setAddress("main-street");
        request.setPhoneNumber("08123641362");
        CustomerSignUpResponse response = customerService.signUp(request);
        assertTrue(response.isSuccess());
    }

    @Test
    void testForCustomerToLogin() {
        CustomerLoginRequest request = new CustomerLoginRequest();
        request.setEmail("john.doe@gmail.com");
        request.setPassword("1234");
        CustomerLoginResponse response = customerService.login(request);
        assertTrue(response.isSuccess());
    }

    @Test
    void testForCustomerToChangePassword() {
        ForgetPasswordRequest request = new ForgetPasswordRequest();
        request.setEmail("2ceeishere@gmail.com");
        ForgetPasswordResponse response = customerService.forgetPassword(request);
        assertTrue(response.isSuccess());
    }



}
