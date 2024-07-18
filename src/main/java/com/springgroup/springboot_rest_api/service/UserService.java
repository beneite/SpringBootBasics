package com.springgroup.springboot_rest_api.service;

import com.springgroup.springboot_rest_api.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser (UserEntity userEntity);
    UserEntity getUserById (Long id);
    List<UserEntity> getAllUsers();

}
