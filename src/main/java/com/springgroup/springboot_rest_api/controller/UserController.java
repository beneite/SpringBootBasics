package com.springgroup.springboot_rest_api.controller;

import com.springgroup.springboot_rest_api.entity.UserEntity;
import com.springgroup.springboot_rest_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    // Api to create user, end point: http://localhost:8080/api/user/create
    @PostMapping("create")
    public ResponseEntity<UserEntity> createUserApi(@RequestBody UserEntity userEntity){
        UserEntity savedUser = userService.createUser(userEntity);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Api to get the user by id, end point: http://localhost:8080/api/user/getUserById/2
    @GetMapping("getUserById/{id}")
    public ResponseEntity<UserEntity> getUserByIdApi(@PathVariable("id") Long userId){
        UserEntity getUser = userService.getUserById(userId);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    // Api to get all the users data, endpoint: http://localhost:8080/api/user/getAllUser
    @GetMapping("getAllUser")
    public ResponseEntity<List<UserEntity>> getAllUsersApi(){
        List<UserEntity> allUsersResponse = userService.getAllUsers();
        return new ResponseEntity<>(allUsersResponse, HttpStatus.OK);
    }

    // Api to update the users data, endpoint: http://localhost:8080/api/user/update/2
    @PutMapping("update/{id}")
    public ResponseEntity<UserEntity> updateUserDetailsApi(@PathVariable("id") Long userId,@RequestBody UserEntity userEntity){
        userEntity.setId(userId);
        UserEntity updatedUser = userService.updateUser(userEntity);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Api to delete the users data, endpoint: http://localhost:8080/api/user/delete/2
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUserApi(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User with id:"+userId+" Deleted", HttpStatus.OK);
    }

}
