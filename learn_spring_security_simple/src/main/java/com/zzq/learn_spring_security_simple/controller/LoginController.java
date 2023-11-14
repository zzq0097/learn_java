package com.zzq.learn_spring_security_simple.controller;

import com.zzq.learn_spring_security_simple.model.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("hello")
    public R<?> hello() {
        return R.ok("hello");
    }

    @GetMapping("anon")
    public R<?> anon() {
        return R.ok("anon");
    }


}
