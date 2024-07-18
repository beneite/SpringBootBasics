package com.springgroup.springboot_rest_api.service.implementation;

import com.springgroup.springboot_rest_api.entity.UserEntity;
import com.springgroup.springboot_rest_api.repository.UserRepository;
import com.springgroup.springboot_rest_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(Long id) {
        Optional<UserEntity> entityOptional = userRepository.findById(id);
        return entityOptional.get();
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity existingData = userRepository.findById(userEntity.getId()).get();
        // setting the new data to the existing one
        existingData.setFirstName(userEntity.getFirstName());
        existingData.setLastName(userEntity.getLastName());
        existingData.setEmail(userEntity.getEmail());
        userRepository.save(existingData);      // saving the data
        return existingData;
    }

}
