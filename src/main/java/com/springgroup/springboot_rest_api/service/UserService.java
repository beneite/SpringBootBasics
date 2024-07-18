package com.springgroup.springboot_rest_api.service;

import com.springgroup.springboot_rest_api.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser (UserEntity userEntity);
    UserEntity getUserById (Long userId);
    List<UserEntity> getAllUsers();
    UserEntity updateUser(UserEntity userEntity);
    void deleteUser(Long userId);

}
