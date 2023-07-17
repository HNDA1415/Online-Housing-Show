package com.dinger.onlinehousingshow.mapper;

import com.dinger.onlinehousingshow.dto.UserDto;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.request.UserRequest;
import com.dinger.onlinehousingshow.response.UserSaveResponse;
import com.dinger.onlinehousingshow.response.UserUpdateResponse;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class UserMapperImplementation implements UserMapper{
    @Override
    public UserDto toUserUpdateDto(UserRequest userRequest) {
        UserDto userDto = new UserDto();
        userDto.setOwnerUserName(userRequest.getOwnerUserName());
        userDto.setOwnerName(userRequest.getOwnerName());
        userDto.setEmail(userRequest.getEmail());
        userDto.setPassword(userRequest.getPassword());
        userDto.setCreatedDate(userRequest.getCreatedDate());
        userDto.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
        return userDto;
    }

    @Override
    public User toUserEntity(UserDto userDto) {
        User user = new User();
        user.setOwnerUserName(userDto.getOwnerUserName());
        user.setOwnerName(userDto.getOwnerName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedDate(userDto.getCreatedDate());
        return user;
    }

    @Override
    public UserDto toUserDto(User saveUser) {
        UserDto userDto = new UserDto();
        userDto.setId(saveUser.getId());
        userDto.setOwnerUserName(saveUser.getOwnerUserName());
        userDto.setOwnerName(saveUser.getOwnerName());
        userDto.setEmail(saveUser.getEmail());
        userDto.setPassword(saveUser.getPassword());
        userDto.setCreatedDate(saveUser.getCreatedDate());
        userDto.setUpdatedDate(saveUser.getUpdatedDate());

        return userDto;
    }

    @Override
    public UserSaveResponse toUserSaveResponse(UserDto saved) {
        UserSaveResponse userResponse = new UserSaveResponse();
        userResponse.setId(saved.getId());
        userResponse.setOwnerUserName(saved.getOwnerUserName());
        userResponse.setOwnerName(saved.getOwnerName());
        userResponse.setEmail(saved.getEmail());
        userResponse.setCreatedDate(saved.getCreatedDate());
        return userResponse;
    }

    @Override
    public UserUpdateResponse toUserUpdateResponse(UserDto saved) {
        UserUpdateResponse userResponse = new UserUpdateResponse();
        userResponse.setId(saved.getId());
        userResponse.setOwnerUserName(saved.getOwnerUserName());
        userResponse.setOwnerName(saved.getOwnerName());
        userResponse.setEmail(saved.getEmail());
        userResponse.setCreatedDate(saved.getCreatedDate());
        userResponse.setUpdatedDate(saved.getUpdatedDate());
        return userResponse;
    }

    @Override
    public UserDto toUserSaveDto(UserRequest userRequest) {
        UserDto userDto = new UserDto();
        userDto.setOwnerUserName(userRequest.getOwnerUserName());
        userDto.setOwnerName(userRequest.getOwnerName());
        userDto.setEmail(userRequest.getEmail());
        userDto.setPassword(userRequest.getPassword());
        userDto.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        return userDto;
    }
}
