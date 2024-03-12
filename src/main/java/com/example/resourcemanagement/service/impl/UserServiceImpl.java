package com.example.resourcemanagement.service.impl;

import com.example.resourcemanagement.dto.RegistrationDTO;
import com.example.resourcemanagement.models.User;
import com.example.resourcemanagement.repository.UserRepository;
import com.example.resourcemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveUser(RegistrationDTO registrationDTO) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
