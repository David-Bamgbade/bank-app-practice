package com.bankapp.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerLoginResponse {
    private boolean success;
    private String message;
}
