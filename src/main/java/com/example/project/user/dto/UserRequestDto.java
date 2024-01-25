package com.example.project.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequestDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
