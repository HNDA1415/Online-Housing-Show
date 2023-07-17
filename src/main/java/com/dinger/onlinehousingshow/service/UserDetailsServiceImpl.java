package com.dinger.onlinehousingshow.service;

import com.dinger.onlinehousingshow.Exception.BadRequestException;
import com.dinger.onlinehousingshow.Security.UserPrincipal;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new BadRequestException("Email incorrect."));

        return UserPrincipal.build(user);
    }

}
