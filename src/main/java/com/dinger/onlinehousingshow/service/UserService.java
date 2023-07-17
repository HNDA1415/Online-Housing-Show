package com.dinger.onlinehousingshow.service;

import com.dinger.onlinehousingshow.dto.UserDto;
import com.dinger.onlinehousingshow.entity.User;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    UserDto updateUser(Long id, UserDto userDto);

    User getUserById(Long id);
}
