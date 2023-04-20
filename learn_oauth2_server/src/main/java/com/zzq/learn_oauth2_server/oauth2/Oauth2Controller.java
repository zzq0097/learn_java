package com.zzq.learn_oauth2_server.oauth2;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zzq.learn_oauth2_server.common.constants.Sys;
import com.zzq.learn_oauth2_server.common.model.resp.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.bind.annotation.*;


/**
 *
 */
@RestController
@RequestMapping("oauth2")
public class Oauth2Controller {
    @Autowired
    private Oauth2Service oauth2Service;

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

    /* ----------------------------- */

    /**
     * 第三方登录
     */
    @GetMapping("login/{system}")
    public void login(@PathVariable String system, HttpServletResponse httpServletResponse) throws Exception {
        AuthRequest authRequest = Sys.authRequestMap.get(system);
        httpServletResponse.sendRedirect(authRequest.authorize("state"));
    }

    /**
     * 第三方登录回调
     */
    @GetMapping("callback/{system}")
    public R<?> callback(@PathVariable String system, AuthCallback authCallback, HttpServletRequest httpServletRequest) throws Exception {
        AuthRequest authRequest = Sys.authRequestMap.get(system);
        AuthResponse<?> authResponse = authRequest.login(authCallback);

        if (authResponse.ok()) {
            JSONObject obj = JSONUtil.parseObj(authResponse.getData());
            Object uuid = obj.get("uuid");

            // TODO
            // 1. 第一次登录创建用户
            // 2. 注册后并登录返回token

            return R.ok(authResponse.getData());
        }
        return R.fail("登录失败");
    }


    /* -------------------------------- */
    // 默认的

    // - GET  /oauth2/authorize
    // - POST /oauth2/token
    // - POST /oauth2/introspect
    // - POST /oauth2/revoke



}
