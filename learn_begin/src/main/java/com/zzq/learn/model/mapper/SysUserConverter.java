package com.zzq.learn.model.mapper;

import com.zzq.learn.model.dto.UserUpdateDTO;
import com.zzq.learn.model.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SysUserConverter {

    UserUpdateDTO entity2updateDto(SysUser sysUser);
}
