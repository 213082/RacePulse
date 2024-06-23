package com.example.racepulse.service;

import com.example.racepulse.dto.RegistrationDto;
import com.example.racepulse.models.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);
    void saveUser(UserEntity user);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
    UserEntity findById(Long id);
    List<UserEntity> findAll();
}
