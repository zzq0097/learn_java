package com.zzq.learn.ago.learn.dto;


import com.zzq.learn.ago.learn.entity.SysUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysUserDTO extends SysUser {
    private String levelName;
}
