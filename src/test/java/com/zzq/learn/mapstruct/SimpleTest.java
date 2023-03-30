package com.zzq.learn.mapstruct;

import com.zzq.learn.model.dto.UserUpdateDTO;
import com.zzq.learn.model.entity.SysUser;
import com.zzq.learn.model.mapper.SysUserConverter;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleTest {
    @Resource
    private SysUserConverter sysUserConverter;

    @Test
    public void test() {
        SysUser sysUser = new SysUser();
        sysUser.setNickname("nickname");
        UserUpdateDTO userUpdateDTO = sysUserConverter.entity2updateDto(sysUser);
        System.out.println(userUpdateDTO);
    }
}
