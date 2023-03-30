package com.zzq.learn.model.mapper;

import com.zzq.learn.model.dto.UserUpdateDTO;
import com.zzq.learn.model.entity.SysUser;
import org.mapstruct.Mapper;

@Mapper
public interface SysUserMapper {

    UserUpdateDTO entity2updateDto(SysUser sysUser);
}
