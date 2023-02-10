package com.zzq.learn.event;

import com.zzq.learn.model.entity.User;
import lombok.Data;

@Data
public class LoginEvent {
    private User user;
}
