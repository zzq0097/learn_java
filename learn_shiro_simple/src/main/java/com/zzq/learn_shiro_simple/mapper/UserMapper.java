package com.zzq.learn_shiro_simple.mapper;

import com.mybatisflex.core.BaseMapper;
import com.mybatisflex.core.query.QueryWrapper;
import com.zzq.learn_shiro_simple.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 映射层。
 *
 * @author ZZQ
 * @since 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    default UserEntity selectByUsername(String username) {
        return selectOneByQuery(QueryWrapper.create().where(UserEntity::getUsername).eq(username));
    }

}
