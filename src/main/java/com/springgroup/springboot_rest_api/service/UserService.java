package com.springgroup.springboot_rest_api.service;

import com.springgroup.springboot_rest_api.entity.UserEntity;

public interface UserService {

    UserEntity createUser (UserEntity userEntity);
    UserEntity getUserById (Long id);

}
