package com.zzq.learn.event;

import com.zzq.learn.model.entity.SysUser;
import lombok.Data;

@Data
public class LoginEvent {
    private SysUser sysUser;
}
