package com.zzq.learn_shiro_simple.controller;

import com.mybatisflex.core.paginate.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.zzq.learn_shiro_simple.service.IUserService;
import com.zzq.learn_shiro_simple.model.entity.UserEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

import com.zzq.learn_shiro_simple.model.result.R;

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

    /**
     * 添加
     *
     * @param user
     * @return {@code true} 添加成功，{@code false} 添加失败
     */
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody UserEntity user) {
        return R.ok(userService.save(user));
    }


    /**
     * 根据主键删除
     *
     * @param id 主键
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @DeleteMapping("/remove/{id}")
    public R<Boolean> remove(@PathVariable Serializable id) {
        return R.ok(userService.removeById(id));
    }


    /**
     * 根据主键更新
     *
     * @param user
     * @return {@code true} 更新成功，{@code false} 更新失败
     */
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody UserEntity user) {
        return R.ok(userService.updateById(user));
    }


    /**
     * 查询所有
     *
     * @return 所有数据
     */
    @GetMapping("/list")
    public R<List<UserEntity>> list() {
        return R.ok(userService.list());
    }


    /**
     * 根据主键获取详细信息。
     *
     * @param id user主键
     * @return 详情
     */
    @GetMapping("/getInfo/{id}")
    public R<UserEntity> getInfo(@PathVariable Serializable id) {
        return R.ok(userService.getById(id));
    }


    /**
     * 分页查询
     *
     * @param page 分页对象
     * @return 分页对象
     */
    @GetMapping("/page")
    public R<Page<UserEntity>> page(Page<UserEntity> page) {
        return R.ok(userService.page(page));
    }
}