package com.example.resourcemanagement.dto;

import jakarta.validation.constraints.NotEmpty;

public class RegistrationDTO {
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
