package com.springgroup.springboot_rest_api.service.implementation;

import com.springgroup.springboot_rest_api.dto.UserDto;
import com.springgroup.springboot_rest_api.entity.UserEntity;
import com.springgroup.springboot_rest_api.mapper.UserMapper;
import com.springgroup.springboot_rest_api.repository.UserRepository;
import com.springgroup.springboot_rest_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = UserMapper.convertToJpa(userDto);     // userEntity is of type JPA
        UserEntity savedEntity = userRepository.save(userEntity);     // savedEntity is of type JPA
        UserDto savedUserDto = UserMapper.convertToDto(savedEntity);    // savedUserDto os of type DTO
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<UserEntity> entityOptional = userRepository.findById(id);
        UserDto userGetDto = UserMapper.convertToDto(entityOptional.get());
        return userGetDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> allUsers = userRepository.findAll();
        return allUsers.stream().map(e-> UserMapper.convertToDto(e)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserEntity existingData = userRepository.findById(userDto.getId()).get();
        // setting the new data to the existing one
        existingData.setFirstName(userDto.getFirstName());
        existingData.setLastName(userDto.getLastName());
        existingData.setEmail(userDto.getEmail());
        // saving the data
        UserEntity savedUser = userRepository.save(existingData);
        return UserMapper.convertToDto(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
