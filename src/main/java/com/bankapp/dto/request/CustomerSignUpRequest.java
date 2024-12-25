package com.bankapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerSignUpRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
}
