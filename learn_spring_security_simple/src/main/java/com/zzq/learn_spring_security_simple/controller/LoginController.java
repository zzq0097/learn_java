package com.zzq.learn_spring_security_simple.controller;

import com.zzq.learn_spring_security_simple.model.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("hello")
    public R<?> hello() {
        return R.ok("hello");
    }

    @PostMapping("login")
    public R<?> login() {
        return R.fail();
    }


}
