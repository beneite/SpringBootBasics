package com.springgroup.springboot_rest_api.controller;

import com.springgroup.springboot_rest_api.entity.UserEntity;
import com.springgroup.springboot_rest_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<UserEntity> createUserApi(@RequestBody UserEntity userEntity){
        UserEntity savedUser = userService.createUser(userEntity);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
