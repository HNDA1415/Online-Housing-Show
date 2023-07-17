package com.dinger.onlinehousingshow.controller;

import com.dinger.onlinehousingshow.dto.UserDto;
import com.dinger.onlinehousingshow.mapper.UserMapper;
import com.dinger.onlinehousingshow.request.UserRequest;
import com.dinger.onlinehousingshow.response.UserSaveResponse;
import com.dinger.onlinehousingshow.response.UserUpdateResponse;
import com.dinger.onlinehousingshow.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UserController {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder, UserMapper userMapper, UserService userService) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = userMapper;
        this.userService = userService;
    }
    @PostMapping(path = "/saveOwner")
    public UserSaveResponse saveOwner(@RequestBody UserRequest userRequest){
    userRequest.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
    UserDto userDto = userMapper.toUserSaveDto(userRequest);
    UserDto saved = userService.saveUser(userDto);
    UserSaveResponse userResponse = userMapper.toUserSaveResponse(saved);
    return userResponse;
    }

    @PutMapping(path = "/updateOwner/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserUpdateResponse updateOwner(@PathVariable Long id, @RequestBody UserRequest userRequest){
        UserDto userDto = userMapper.toUserUpdateDto(userRequest);
        UserDto saved = userService.updateUser(id,userDto);
        UserUpdateResponse response = userMapper.toUserUpdateResponse(saved);
        return response;
    }
}
