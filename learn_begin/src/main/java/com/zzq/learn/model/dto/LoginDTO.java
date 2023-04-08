package com.zzq.learn.model.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

@Setter
@Getter
public class LoginDTO {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String code;
}
