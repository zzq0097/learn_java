package com.zzq.learn.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RegisterDTO {
    @NotBlank
    private String nickname;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private String tel;
    private String email;
    @NotBlank
    private String code;
}
