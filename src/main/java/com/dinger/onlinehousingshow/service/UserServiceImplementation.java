package com.dinger.onlinehousingshow.service;

import com.dinger.onlinehousingshow.dto.UserDto;
import com.dinger.onlinehousingshow.entity.Role;
import com.dinger.onlinehousingshow.entity.User;
import com.dinger.onlinehousingshow.mapper.UserMapper;
import com.dinger.onlinehousingshow.repository.RoleRepository;
import com.dinger.onlinehousingshow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;

@Service
public class UserServiceImplementation implements UserService{

    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserServiceImplementation(UserMapper userMapper, RoleRepository roleRepository, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toUserEntity(userDto);
        Role role = roleRepository.findByRoleName("ROLE_ADMIN");
        user.setRoles(Collections.singleton(role));
        user.setOwnerName(userDto.getOwnerName());
        user.setOwnerUserName(userDto.getOwnerUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedDate(userDto.getCreatedDate());
        User saveUser = userRepository.save(user);
        UserDto saved = userMapper.toUserDto(saveUser);
        return saved;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.getById(id);
        user.setOwnerName(userDto.getOwnerName());
        user.setOwnerUserName(userDto.getOwnerUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedDate(userDto.getCreatedDate());
        user.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
        User saveUser = userRepository.save(user);
        UserDto saved = userMapper.toUserDto(saveUser);

        return saved;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }
}
