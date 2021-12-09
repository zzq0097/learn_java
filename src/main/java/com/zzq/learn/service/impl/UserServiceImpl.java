package com.zzq.learn.service.impl;

import com.zzq.learn.model.entity.User;
import com.zzq.learn.mapper.UserMapper;
import com.zzq.learn.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZZQ
 * @since 2021-12-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
