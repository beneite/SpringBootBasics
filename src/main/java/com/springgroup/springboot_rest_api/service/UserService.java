package com.springgroup.springboot_rest_api.service;

import com.springgroup.springboot_rest_api.dto.UserDto;
import com.springgroup.springboot_rest_api.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserDto createUser (UserDto userEntity);
    UserDto getUserById (Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);

}
