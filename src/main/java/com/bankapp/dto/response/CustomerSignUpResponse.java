package com.bankapp.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerSignUpResponse {
    private String message;
    private boolean isSuccess;
}
