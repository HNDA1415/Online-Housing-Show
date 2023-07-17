package com.dinger.onlinehousingshow.mapper;

import com.dinger.onlinehousingshow.dto.UserDto;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.request.UserRequest;
import com.dinger.onlinehousingshow.response.UserSaveResponse;
import com.dinger.onlinehousingshow.response.UserUpdateResponse;

public interface UserMapper {
    UserDto toUserUpdateDto(UserRequest userRequest);

    User toUserEntity(UserDto userDto);

    UserDto toUserDto(User saveUser);

    UserSaveResponse toUserSaveResponse(UserDto saved);

    UserUpdateResponse toUserUpdateResponse(UserDto saved);

    UserDto toUserSaveDto(UserRequest userRequest);

}
