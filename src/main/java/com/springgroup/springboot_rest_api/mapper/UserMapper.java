package com.springgroup.springboot_rest_api.mapper;

import com.springgroup.springboot_rest_api.dto.UserDto;
import com.springgroup.springboot_rest_api.entity.UserEntity;

public class UserMapper {

    /**
     * method to convert DTO object to JPA
     * @param userDto - DTO object
     * @return - JPA object after conversion
     */
    public static UserEntity convertToJpa(UserDto userDto){
        UserEntity userEntity = new UserEntity(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );

        return userEntity;
    }

    /**
     * method to convert JPA object to DTO
     * @param userEntity - JPA object
     * @return - DTO object after conversion
     */
    public static UserDto convertToDto(UserEntity userEntity){
        UserDto userDto = new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail()
        );

        return userDto;
    }
}
