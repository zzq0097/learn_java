package com.zzq.learn_shiro_simple.service.impl;


import org.springframework.stereotype.Service;
import com.zzq.learn_shiro_simple.service.IUserService;
import com.zzq.learn_shiro_simple.model.entity.UserEntity;
import com.zzq.learn_shiro_simple.mapper.UserMapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;

/**
 * 服务层实现。
 *
 * @author ZZQ
 * @since 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

}
