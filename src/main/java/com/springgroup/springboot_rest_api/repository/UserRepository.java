package com.springgroup.springboot_rest_api.repository;

import com.springgroup.springboot_rest_api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
