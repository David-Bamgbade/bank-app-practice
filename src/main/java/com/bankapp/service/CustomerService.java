package com.bankapp.service;

import com.bankapp.dto.request.CustomerLoginRequest;
import com.bankapp.dto.request.CustomerSignUpRequest;
import com.bankapp.dto.request.ForgetPasswordRequest;
import com.bankapp.dto.response.CustomerLoginResponse;
import com.bankapp.dto.response.CustomerSignUpResponse;
import com.bankapp.dto.response.ForgetPasswordResponse;

public interface CustomerService {
    CustomerSignUpResponse signUp(CustomerSignUpRequest request);
    CustomerLoginResponse login(CustomerLoginRequest request);
//    ForgetPasswordResponse forgetPassword(ForgetPasswordRequest request);
}
