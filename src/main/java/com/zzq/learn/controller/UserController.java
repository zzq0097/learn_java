package com.zzq.learn.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzq.learn.model.dto.base.PageDTO;
import com.zzq.learn.model.entity.User;
import com.zzq.learn.service.IUserService;
import com.zzq.learn.util.SaltUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.zzq.learn.model.result.R;

/**
 * <p>
 *  前端控制器
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


    @PostMapping("login")
    public R login(@RequestBody User user) {
        long count = userService.query().eq("name", user.getName()).count();
        if (count == 1) {
            User one = userService.query().eq("name", user.getName()).one();
            return SaltUtil.md5Eq(one.getPassword(),user.getPassword(),one.getSalt()) ? ok() : fail();
        }
        return fail();
    }

    @GetMapping("get")
    public R get(String name, PageDTO page) {
        return ok(userService.query().eq(StrUtil.isNotBlank(name), "name",name)
                .page(new Page<>(page.getCurr(), page.getSize())));
    }

    @PostMapping("add")
    public R add(@RequestBody User user) {
        String salt = SaltUtil.createSalt();
        user.setSalt(salt);
        user.setPassword(SaltUtil.md5(user.getPassword(), salt));
        return userService.save(user) ? ok(user.getId()) : fail();
    }

}
