package com.zzq.learn.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzq.learn.enums.SysError;
import com.zzq.learn.event.LoginEvent;
import com.zzq.learn.mapper.SysUserMapper;
import com.zzq.learn.model.dto.LoginDTO;
import com.zzq.learn.model.dto.PageDTO;
import com.zzq.learn.model.dto.RegisterDTO;
import com.zzq.learn.model.dto.UserUpdateDTO;
import com.zzq.learn.model.entity.SysUser;
import com.zzq.learn.model.result.R;
import com.zzq.learn.model.vo.UserInfoVO;
import com.zzq.learn.service.ISysUserService;
import com.zzq.learn.util.SaltUtil;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ZZQ
 * @since 2021-12-09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class SysUserController {
    private final ApplicationEventPublisher eventPublisher;
    private final ISysUserService userService;
    //    private final AuthenticationManager authenticationManager;
    private final SysUserMapper sysUserMapper;

    @GetMapping("code")
    public void code(HttpServletResponse response, HttpSession session) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        session.setAttribute("code", lineCaptcha.getCode());
        lineCaptcha.write(response.getOutputStream());
        response.setContentType("image/png");
    }

    @PostMapping("register")
    public R<?> register(@RequestBody @Valid RegisterDTO dto, HttpSession session) {
        if (!Objects.equals(dto.getCode(), session.getAttribute("code"))) {
            return R.fail(SysError.CodeFail);
        }
        if (sysUserMapper.userExists(dto.getUsername())) {
            return R.fail(SysError.DataRepeat);
        }
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(dto, sysUser);
        return add(sysUser);
    }

    @PostMapping("login")
    public R<?> login(@RequestBody @Valid LoginDTO dto) {
        long count = userService.query().eq("username", dto.getUsername()).count();
        if (count == 1) {
            SysUser one = userService.query().eq("username", dto.getUsername()).one();
            if (SaltUtil.md5Eq(one.getPassword(), dto.getPassword(), one.getSalt())) {
                UserInfoVO userInfo = new UserInfoVO();
                BeanUtil.copyProperties(one, userInfo);
                eventPublisher.publishEvent(new LoginEvent());
                return R.ok(userInfo);
            }
            return R.fail(SysError.LoginFail);
        } else if (count == 0)
            return R.fail("用户不存在");
        return R.fail();
    }

    @PostMapping("login2")
    public R<?> login2(@RequestBody @Valid LoginDTO dto, HttpSession httpSession) {
        String code = httpSession.getAttribute("code").toString();
        if (!StrUtil.equals(code, dto.getCode())) {
            return R.fail("验证码错误");
        }
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
//        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//        if (authenticate != null && authenticate.isAuthenticated()) {
//            return R.ok();
//        }
        return R.fail("登陆失败");
    }

    @GetMapping("status")
    public R<?> status(HttpSession session) {
        return R.ok(session.getId());
    }

    @GetMapping("logout")
    public R<?> logout(HttpSession session) {
        session.invalidate();
        return R.ok();
    }

    @PostMapping("reset")
    public R<?> reset(Long userId, String oldPassword, String newPassword) {
        SysUser sysUser = userService.getById(userId);
        if (sysUser == null)
            return R.fail("用户不存在");
        if (!SaltUtil.md5Eq(sysUser.getPassword(), oldPassword, sysUser.getSalt())) {
            return R.fail("原密码错误");
        }
        sysUser.setPassword(newPassword);
        SaltUtil.setPassword(sysUser);
        return userService.updateById(sysUser) ? R.ok() : R.fail(SysError.UpdateFail);
    }

    @GetMapping("get")
    public R<?> get(String nickname, PageDTO page) {
        return R.ok(userService.query()
                .select("id,nickname,username,tel,email,create_time,update_time")
                .eq(StrUtil.isNotBlank(nickname), "nickname", nickname)
                .page(new Page<>(page.getCurr(), page.getSize())));
    }

    @PostMapping("add")
    public R<?> add(@RequestBody SysUser sysUser) {
        SaltUtil.setPassword(sysUser);
        return userService.save(sysUser) ? R.ok(sysUser.getId()) : R.fail(SysError.AddFail);
    }

    @PostMapping("update")
    public R<?> update(@RequestBody UserUpdateDTO dto) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(dto, sysUser);
        return userService.updateById(sysUser) ? R.ok() : R.fail(SysError.UpdateFail);
    }

    @PostMapping("del")
    public R<?> del(@RequestBody List<Long> ids) {
        userService.deleteUsers(ids);
        return R.ok();
    }

}
