package com.springgroup.springboot_rest_api.service.implementation;

import com.springgroup.springboot_rest_api.dto.UserDto;
import com.springgroup.springboot_rest_api.entity.UserEntity;
import com.springgroup.springboot_rest_api.mapper.AutoUserMapper;
import com.springgroup.springboot_rest_api.mapper.UserMapper;
import com.springgroup.springboot_rest_api.repository.UserRepository;
import com.springgroup.springboot_rest_api.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = AutoUserMapper.MAPPER.mapToJpa(userDto);     // userEntity is of type JPA
        UserEntity savedEntity = userRepository.save(userEntity);     // savedEntity is of type JPA
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToDto(savedEntity);   // savedUserDto os of type DTO
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<UserEntity> entityOptional = userRepository.findById(id);
        UserDto userGetDto = AutoUserMapper.MAPPER.mapToDto(entityOptional.get());
        return userGetDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserEntity-> AutoUserMapper.MAPPER.mapToDto(UserEntity)).collect(Collectors.toList());
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
        return AutoUserMapper.MAPPER.mapToDto(savedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
