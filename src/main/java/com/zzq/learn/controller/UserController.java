package com.zzq.learn.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzq.learn.enums.SysError;
import com.zzq.learn.model.dto.LoginDTO;
import com.zzq.learn.model.dto.PageDTO;
import com.zzq.learn.model.dto.RegisterDTO;
import com.zzq.learn.model.entity.User;
import com.zzq.learn.service.IUserService;
import com.zzq.learn.util.SaltUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.zzq.learn.model.result.R;

import javax.servlet.ServletOutputStream;
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
public class UserController extends R {
    private final IUserService userService;

    @GetMapping("code")
    public void code(HttpServletResponse response, HttpSession session) throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        session.setAttribute("code", lineCaptcha.getCode());
        lineCaptcha.write(response.getOutputStream());
        response.setContentType("image/png");
    }

    @PostMapping("register")
    public R register(@RequestBody @Valid RegisterDTO dto, HttpSession session) {
        if (!Objects.equals(dto.getCode(), session.getAttribute("code"))) {
            return fail(SysError.CodeFail);
        }
        long count = userService.query().eq("name", dto.getUsername()).count();
        if (count > 0) {
            return fail(SysError.DataRepeat);
        }
        User user = new User();
        user.setName(dto.getUsername());
        user.setPassword(dto.getPassword());
        return add(user);
    }

    @PostMapping("login")
    public R login(@RequestBody @Valid LoginDTO dto) {
        long count = userService.query().eq("name", dto.getUsername()).count();
        if (count == 1) {
            User one = userService.query().eq("name", dto.getUsername()).one();
            return SaltUtil.md5Eq(one.getPassword(), dto.getPassword(), one.getSalt()) ? ok() : fail(SysError.LoginFail);
        } else if (count == 0)
            return fail("用户不存在");
        return fail();
    }

    @GetMapping("get")
    public R get(String name, PageDTO page) {
        return ok(userService.query()
                .eq(StrUtil.isNotBlank(name), "name", name)
                .page(new Page<>(page.getCurr(), page.getSize())));
    }

    @PostMapping("add")
    public R add(@RequestBody User user) {
        String salt = SaltUtil.createSalt();
        user.setSalt(salt);
        user.setPassword(SaltUtil.md5(user.getPassword(), salt));
        return userService.save(user) ? ok(user.getId()) : fail(SysError.AddFail);
    }

    @PostMapping("del")
    public R del(@RequestBody List<Long> ids) {
        return userService.removeByIds(ids) ? ok() : fail(SysError.DelFail);
    }

}
