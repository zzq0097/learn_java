package com.zzq.learn.ago.learn.mapper;

import com.zzq.learn.ago.learn.dto.SysUserDTO;
import com.zzq.learn.ago.learn.entity.SysUser;
import org.apache.ibatis.annotations.SelectProvider;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.select.join.EqualTo;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;

import static com.zzq.learn.ago.learn.mapper.SysDeptDynamicSqlSupport.sysDept;
import static com.zzq.learn.ago.learn.mapper.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;

public interface SysUserExtMapper extends SysUserMapper {

    BasicColumn[] selectDTOList = new BasicColumn[]{sysUser.allColumns(), sysDept.levelName};

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    List<SysUserDTO> selectDTOMany(SelectStatementProvider selectStatement);


    default Long count() {
        return count(dsl -> dsl
                .where(sysUser.id, isEqualTo(1L))
        );
    }

    default List<SysUser> getByName(String name) {
        return select(dsl -> dsl
                .where(sysUser.nickName, isEqualTo(name)));
    }

    default List<SysUserDTO> selectTest() {
        return MyBatis3Utils.selectList(this::selectDTOMany, selectDTOList, sysUser, dsl -> dsl
                .leftJoin(sysDept).on(sysUser.deptId, new EqualTo(sysDept.id)));
    }


    default int insertTest(List<SysUser> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, sysUser, dsl -> dsl);
    }

    default int deleteTest(List<Long> ids) {
        return delete(dsl -> dsl.where(sysUser.id, isIn(ids)));
    }


    @Override
    default int insertMultiple(Collection<SysUser> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, sysUser, c ->
                c.map(deptId).toProperty("deptId")
                        .map(deptName).toProperty("deptName")
                        .map(username).toProperty("username")
                        .map(nickName).toProperty("nickName")
                        .map(phone).toProperty("phone")
                        .map(pass).toProperty("pass")
                        .map(initial).toProperty("initial")
                        .map(isAdmin).toProperty("isAdmin")
                        .map(state).toProperty("state")
                        .map(enabled).toProperty("enabled")
                        // 数据库字段非空，默认值0
                        // .map(mailbox).toProperty("mailbox")
                        .map(pwdResetTime).toProperty("pwdResetTime")
                        .map(userId).toProperty("userId")
                        .map(updateBy).toProperty("updateBy")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
        );
    }


}
