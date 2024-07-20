package com.springgroup.springboot_rest_api.mapper;

import com.springgroup.springboot_rest_api.dto.UserDto;
import com.springgroup.springboot_rest_api.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToDto(UserEntity userEntity);

    UserEntity mapToJpa(UserDto userDto);
}
