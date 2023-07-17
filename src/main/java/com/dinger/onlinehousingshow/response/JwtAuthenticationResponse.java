package com.dinger.onlinehousingshow.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JwtAuthenticationResponse {

    private String token;
    private Date expiredAt;

    public JwtAuthenticationResponse(String token, Date expiredAt) {
        this.token = token;
        this.expiredAt = expiredAt;
    }
}
