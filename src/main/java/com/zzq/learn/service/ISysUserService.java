package com.zzq.learn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.learn.model.entity.SysUser;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ZZQ
 * @since 2021-12-09
 */
public interface ISysUserService extends IService<SysUser> {

    SysUser findUserByUsername(String username);

    SysUser findUserById(Long userId);

    List<SysUser> listUser();

    SysUser createUser(SysUser sysUser);

    SysUser updateUser(SysUser sysUser);

    void deleteUser(Long userId);

    void deleteUsers(List<Long> ids);
}
