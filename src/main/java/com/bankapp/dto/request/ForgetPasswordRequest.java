package com.bankapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForgetPasswordRequest {
    private String password;
    private String email;
}
