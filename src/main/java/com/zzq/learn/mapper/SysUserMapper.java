package com.zzq.learn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zzq.learn.model.entity.SysUser;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ZZQ
 * @since 2021-12-09
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    default SysUser selectByUsername(String username) {
        return selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
    }

    default Boolean userExists(String username) {
        return selectCount(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username)) > 0;
    }

    default Boolean userExists(Long userId) {
        return selectCount(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getId, userId)) > 0;
    }

}
