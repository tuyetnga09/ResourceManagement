package com.example.resourcemanagement.service;

import com.example.resourcemanagement.dto.RegistrationDTO;
import com.example.resourcemanagement.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(RegistrationDTO registrationDTO);
    User findByEmail(String email);
    User findByUsername(String username);
}
