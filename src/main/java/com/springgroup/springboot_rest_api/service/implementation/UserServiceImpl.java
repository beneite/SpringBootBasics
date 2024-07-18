package com.springgroup.springboot_rest_api.service.implementation;

import com.springgroup.springboot_rest_api.entity.UserEntity;
import com.springgroup.springboot_rest_api.repository.UserRepository;
import com.springgroup.springboot_rest_api.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

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

}
