package com.bankapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerLoginRequest {
    private String password;
    private String email;
    private boolean loggedIn;
}
