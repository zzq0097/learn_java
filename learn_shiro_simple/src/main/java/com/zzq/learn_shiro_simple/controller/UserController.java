package com.zzq.learn_shiro_simple.controller;

import com.zzq.learn_shiro_simple.mapper.UserMapper;
import com.zzq.learn_shiro_simple.model.result.R;
import com.zzq.learn_shiro_simple.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层。
 *
 * @author ZZQ
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("hello")
    public R<String> hello() {
        return R.ok("hello");
    }

    @GetMapping("login")
    public R<?> login(String username, String password) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        return R.ok();
    }
}
