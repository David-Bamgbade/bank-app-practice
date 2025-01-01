package com.bankapp.controller;

import com.bankapp.dto.request.CustomerLoginRequest;
import com.bankapp.dto.request.CustomerSignUpRequest;
import com.bankapp.dto.request.ForgetPasswordRequest;
import com.bankapp.dto.response.CustomerLoginResponse;
import com.bankapp.dto.response.CustomerSignUpResponse;
import com.bankapp.dto.response.ForgetPasswordResponse;
import com.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    CustomerService customerService;

    @PostMapping("signUp")
    ResponseEntity<CustomerSignUpResponse> signUpCustomer(@RequestBody CustomerSignUpRequest customerSignUpRequest) {
        try {
           CustomerSignUpResponse response = customerService.signUp(customerSignUpRequest);
           return ResponseEntity.ok(response);
        } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("forgotPassword")
    ResponseEntity<ForgetPasswordResponse> forgotPassword(@RequestBody ForgetPasswordRequest forgetPasswordRequest) {
        try {
            ForgetPasswordResponse response = customerService.forgetPassword(forgetPasswordRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("login")
    ResponseEntity<CustomerLoginResponse> login (@RequestBody CustomerLoginRequest customerLoginRequest) {
        try{
            CustomerLoginResponse response = customerService.login(customerLoginRequest);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }




}
