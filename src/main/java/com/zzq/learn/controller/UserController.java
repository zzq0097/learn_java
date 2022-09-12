package com.zzq.learn.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzq.learn.enums.SysError;
import com.zzq.learn.model.dto.LoginDTO;
import com.zzq.learn.model.dto.PageDTO;
import com.zzq.learn.model.dto.RegisterDTO;
import com.zzq.learn.model.dto.UserUpdateDTO;
import com.zzq.learn.model.entity.User;
import com.zzq.learn.model.vo.UserInfoVO;
import com.zzq.learn.service.IUserService;
import com.zzq.learn.util.SaltUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.zzq.learn.model.result.R;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
public class UserController {
    private final IUserService userService;

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
        long count = userService.query().eq("username", dto.getUsername()).or().eq("nickname",dto.getNickname()).count();
        if (count > 0) {
            return R.fail(SysError.DataRepeat);
        }
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        return add(user);
    }

    @PostMapping("login")
    public R<?> login(@RequestBody @Valid LoginDTO dto) {
        long count = userService.query().eq("username", dto.getUsername()).count();
        if (count == 1) {
            User one = userService.query().eq("username", dto.getUsername()).one();
            if (SaltUtil.md5Eq(one.getPassword(), dto.getPassword(), one.getSalt())) {
                UserInfoVO userInfo = new UserInfoVO();
                BeanUtil.copyProperties(one,userInfo);
                return R.ok(userInfo);
            }
            return R.fail(SysError.LoginFail);
        } else if (count == 0)
            return R.fail("用户不存在");
        return R.fail();
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
        User user = userService.getById(userId);
        if (user == null)
            return R.fail("用户不存在");
        if (!SaltUtil.md5Eq(user.getPassword(), oldPassword, user.getSalt())) {
            return R.fail("原密码错误");
        }
        user.setPassword(newPassword);
        SaltUtil.setPassword(user);
        return userService.updateById(user) ? R.ok() : R.fail(SysError.UpdateFail);
    }

    @GetMapping("get")
    public R<?> get(String nickname, PageDTO page) {
        return R.ok(userService.query()
                .select("id,nickname,username,tel,email,create_time,update_time")
                .eq(StrUtil.isNotBlank(nickname), "nickname", nickname)
                .page(new Page<>(page.getCurr(), page.getSize())));
    }

    @PostMapping("add")
    public R<?> add(@RequestBody User user) {
        SaltUtil.setPassword(user);
        return userService.save(user) ? R.ok(user.getId()) : R.fail(SysError.AddFail);
    }

    @PostMapping("update")
    public R<?> update(@RequestBody UserUpdateDTO dto) {
        User user = new User();
        BeanUtil.copyProperties(dto, user);
        return userService.updateById(user) ? R.ok() : R.fail(SysError.UpdateFail);
    }

    @PostMapping("del")
    public R<?> del(@RequestBody List<Long> ids) {
        return userService.removeByIds(ids) ? R.ok() : R.fail(SysError.DelFail);
    }

}
