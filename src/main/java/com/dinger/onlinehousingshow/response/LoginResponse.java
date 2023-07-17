package com.dinger.onlinehousingshow.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

    private Boolean success;
    private String message;

    public LoginResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
