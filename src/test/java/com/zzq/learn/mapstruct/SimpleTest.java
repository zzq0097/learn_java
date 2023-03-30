package com.zzq.learn.mapstruct;

import com.zzq.learn.model.dto.UserUpdateDTO;
import com.zzq.learn.model.entity.SysUser;
import com.zzq.learn.model.mapper.SysUserMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleTest {
    SysUserMapper sysUserMapper = Mappers.getMapper(SysUserMapper.class);

    @Test
    public void test() {
        SysUser sysUser = new SysUser();
        sysUser.setNickname("nickname");
        UserUpdateDTO userUpdateDTO = sysUserMapper.entity2updateDto(sysUser);
        System.out.println(userUpdateDTO);
    }
}
