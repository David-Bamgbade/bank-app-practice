package com.bankapp.service;

import com.bankapp.dto.request.CustomerLoginRequest;
import com.bankapp.dto.request.CustomerSignUpRequest;
import com.bankapp.dto.request.ForgetPasswordRequest;
import com.bankapp.dto.response.CustomerLoginResponse;
import com.bankapp.dto.response.CustomerSignUpResponse;
import com.bankapp.dto.response.ForgetPasswordResponse;
import com.bankapp.model.Customer;
import com.bankapp.repository.CustomerRepo;
import com.bankapp.security.DetailValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    EmailService emailService;


    @Override
    public CustomerSignUpResponse signUp(CustomerSignUpRequest request) {
        Customer customer = new Customer();
        DetailValidation validation = new DetailValidation();
        customer.setFirstName(validation.validateFirstName(request.getFirstName()));
        customer.setLastName(validation.validateLastName(request.getLastName()));
        customer.setEmail(validation.validateEmail(request.getEmail()));
        customer.setPassword(request.getPassword());
        customer.setPhoneNumber(validation.validatePhoneNumber(request.getPhoneNumber()));
        emailService.sendWelcomeEmail(request.getEmail(), request.getFirstName());
        customerRepo.save(customer);
        CustomerSignUpResponse response = new CustomerSignUpResponse();
        response.setSuccess(true);
        response.setMessage("Successfully signed up");
        return response;
    }

    @Override
    public CustomerLoginResponse login(CustomerLoginRequest request) {
        Optional <Customer> findCustomer = customerRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (findCustomer.isPresent()) {
            findCustomer.get().setLoggedIn(true);
        }
        else {
            throw new RuntimeException("Customer Not Found SignUp");
        }
        CustomerLoginResponse response = new CustomerLoginResponse();
        response.setSuccess(true);
        response.setMessage("Successfully logged in");
        return response;
    }

//    @Override
//    public ForgetPasswordResponse forgetPassword(ForgetPasswordRequest request) {
//        Optional <Customer> findCustomer = customerRepo.findByEmailAndPassword(request.getEmail(), request.getPassword());
//        if (findCustomer.isPresent()) {
//            findCustomer.get().setPassword(request.getPassword());
//        }
//        return null;
//    }

}
