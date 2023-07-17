package com.dinger.onlinehousingshow.controller;

import com.dinger.onlinehousingshow.Security.JwtTokenProvider;
import com.dinger.onlinehousingshow.request.LoginRequest;
import com.dinger.onlinehousingshow.response.JwtAuthenticationResponse;
import com.dinger.onlinehousingshow.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    Date expiredAt = new Date(new Date().getTime() + 86400 * 1000);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        System.out.println(loginRequest.getEmail() + ": " + loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
        );
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateJwtToken(authentication);

            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt,expiredAt));
        }
        return new ResponseEntity<>(new LoginResponse(false,"email or password is incorrect."), HttpStatus.NOT_FOUND);

    }

}
