package com.zzq.learn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzq.learn.mapper.SysUserMapper;
import com.zzq.learn.model.entity.SysUser;
import com.zzq.learn.service.ISysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ZZQ
 * @since 2021-12-09
 */
@Service
public class SysSysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public SysUser findUserByUsername(String username) {
        return baseMapper.selectByUsername(username);
    }

    @Override
    public SysUser findUserById(Long userId) {
        return baseMapper.selectById(userId);
    }

    @Override
    public List<SysUser> listUser() {
        return baseMapper.selectList(null);
    }

    @Override
    public SysUser createUser(SysUser sysUser) {
        if (baseMapper.insert(sysUser) > 0) {
            return sysUser;
        }
        throw new RuntimeException("用户添加失败");
    }

    @Override
    public SysUser updateUser(SysUser sysUser) {
        if (baseMapper.updateById(sysUser) > 0) {
            return sysUser;
        }
        throw new RuntimeException("用户更新失败");
    }

    @Override
    public void deleteUser(Long userId) {
        if (baseMapper.userExists(userId)) {
            if (!(baseMapper.deleteById(userId) > 0)) {
                throw new RuntimeException("用户删除失败");
            }
        }
    }

    @Override
    public void deleteUsers(List<Long> ids) {
        baseMapper.deleteBatchIds(ids);
    }
}
