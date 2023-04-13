package com.zzq.learn_oauth2_server.oauth2;

import com.zzq.learn_oauth2_server.common.model.resp.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 */
@RestController
@RequestMapping("oauth2")
public class Oauth2Controller {

    /**
     * 创建第三方应用
     */
    @PostMapping("createClient")
    public R<?> createClient() {
        return R.ok();
    }

    /**
     * 移除第三方应用
     */
    @PostMapping("removeClient")
    public R<?> removeClient() {
        return R.ok();
    }

    /**
     *
     */
    @PostMapping("login")
    public R<?> login() {
        return R.ok();
    }

    /**
     *
     */
    @PostMapping("logout")
    public R<?> logout() {
        return R.ok();
    }


    /* -------------------------------- */
    // 默认的

    // - GET  /oauth2/authorize
    // - POST /oauth2/token
    // - POST /oauth2/



}