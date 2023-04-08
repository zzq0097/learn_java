package com.zzq.learn.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO {
    private Long id;
    private String nickname;
    private String tel;
    private String email;
}
