package com.zzq.learn.ago.learn.mapper;

import com.zzq.learn.ago.learn.entity.SysUser;
import jakarta.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.zzq.learn.ago.learn.mapper.SysUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, deptId, deptName, username, nickName, phone, pass, initial, isAdmin, state, enabled, mailbox, pwdResetTime, userId, updateBy, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "row.id")
    int insert(InsertStatementProvider<SysUser> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys = true, keyProperty = "records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<SysUser> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "SysUserResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "dept_id", property = "deptId", jdbcType = JdbcType.BIGINT),
            @Result(column = "dept_name", property = "deptName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR),
            @Result(column = "nick_name", property = "nickName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pass", property = "pass", jdbcType = JdbcType.VARCHAR),
            @Result(column = "initial", property = "initial", jdbcType = JdbcType.BIGINT),
            @Result(column = "is_admin", property = "isAdmin", jdbcType = JdbcType.BIT),
            @Result(column = "state", property = "state", jdbcType = JdbcType.BIT),
            @Result(column = "enabled", property = "enabled", jdbcType = JdbcType.BIGINT),
            @Result(column = "mailbox", property = "mailbox", jdbcType = JdbcType.VARCHAR),
            @Result(column = "pwd_reset_time", property = "pwdResetTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "update_by", property = "updateBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<SysUser> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("SysUserResult")
    Optional<SysUser> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysUser row) {
        return MyBatis3Utils.insert(this::insert, row, sysUser, c ->
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
                        .map(mailbox).toProperty("mailbox")
                        .map(pwdResetTime).toProperty("pwdResetTime")
                        .map(userId).toProperty("userId")
                        .map(updateBy).toProperty("updateBy")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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
                        .map(mailbox).toProperty("mailbox")
                        .map(pwdResetTime).toProperty("pwdResetTime")
                        .map(userId).toProperty("userId")
                        .map(updateBy).toProperty("updateBy")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysUser row) {
        return MyBatis3Utils.insert(this::insert, row, sysUser, c ->
                c.map(deptId).toPropertyWhenPresent("deptId", row::getDeptId)
                        .map(deptName).toPropertyWhenPresent("deptName", row::getDeptName)
                        .map(username).toPropertyWhenPresent("username", row::getUsername)
                        .map(nickName).toPropertyWhenPresent("nickName", row::getNickName)
                        .map(phone).toPropertyWhenPresent("phone", row::getPhone)
                        .map(pass).toPropertyWhenPresent("pass", row::getPass)
                        .map(initial).toPropertyWhenPresent("initial", row::getInitial)
                        .map(isAdmin).toPropertyWhenPresent("isAdmin", row::getIsAdmin)
                        .map(state).toPropertyWhenPresent("state", row::getState)
                        .map(enabled).toPropertyWhenPresent("enabled", row::getEnabled)
                        .map(mailbox).toPropertyWhenPresent("mailbox", row::getMailbox)
                        .map(pwdResetTime).toPropertyWhenPresent("pwdResetTime", row::getPwdResetTime)
                        .map(userId).toPropertyWhenPresent("userId", row::getUserId)
                        .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
                        .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
                        .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysUser> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysUser, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(deptId).equalTo(row::getDeptId)
                .set(deptName).equalTo(row::getDeptName)
                .set(username).equalTo(row::getUsername)
                .set(nickName).equalTo(row::getNickName)
                .set(phone).equalTo(row::getPhone)
                .set(pass).equalTo(row::getPass)
                .set(initial).equalTo(row::getInitial)
                .set(isAdmin).equalTo(row::getIsAdmin)
                .set(state).equalTo(row::getState)
                .set(enabled).equalTo(row::getEnabled)
                .set(mailbox).equalTo(row::getMailbox)
                .set(pwdResetTime).equalTo(row::getPwdResetTime)
                .set(userId).equalTo(row::getUserId)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(deptId).equalToWhenPresent(row::getDeptId)
                .set(deptName).equalToWhenPresent(row::getDeptName)
                .set(username).equalToWhenPresent(row::getUsername)
                .set(nickName).equalToWhenPresent(row::getNickName)
                .set(phone).equalToWhenPresent(row::getPhone)
                .set(pass).equalToWhenPresent(row::getPass)
                .set(initial).equalToWhenPresent(row::getInitial)
                .set(isAdmin).equalToWhenPresent(row::getIsAdmin)
                .set(state).equalToWhenPresent(row::getState)
                .set(enabled).equalToWhenPresent(row::getEnabled)
                .set(mailbox).equalToWhenPresent(row::getMailbox)
                .set(pwdResetTime).equalToWhenPresent(row::getPwdResetTime)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysUser row) {
        return update(c ->
                c.set(deptId).equalTo(row::getDeptId)
                        .set(deptName).equalTo(row::getDeptName)
                        .set(username).equalTo(row::getUsername)
                        .set(nickName).equalTo(row::getNickName)
                        .set(phone).equalTo(row::getPhone)
                        .set(pass).equalTo(row::getPass)
                        .set(initial).equalTo(row::getInitial)
                        .set(isAdmin).equalTo(row::getIsAdmin)
                        .set(state).equalTo(row::getState)
                        .set(enabled).equalTo(row::getEnabled)
                        .set(mailbox).equalTo(row::getMailbox)
                        .set(pwdResetTime).equalTo(row::getPwdResetTime)
                        .set(userId).equalTo(row::getUserId)
                        .set(updateBy).equalTo(row::getUpdateBy)
                        .set(createTime).equalTo(row::getCreateTime)
                        .set(updateTime).equalTo(row::getUpdateTime)
                        .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysUser row) {
        return update(c ->
                c.set(deptId).equalToWhenPresent(row::getDeptId)
                        .set(deptName).equalToWhenPresent(row::getDeptName)
                        .set(username).equalToWhenPresent(row::getUsername)
                        .set(nickName).equalToWhenPresent(row::getNickName)
                        .set(phone).equalToWhenPresent(row::getPhone)
                        .set(pass).equalToWhenPresent(row::getPass)
                        .set(initial).equalToWhenPresent(row::getInitial)
                        .set(isAdmin).equalToWhenPresent(row::getIsAdmin)
                        .set(state).equalToWhenPresent(row::getState)
                        .set(enabled).equalToWhenPresent(row::getEnabled)
                        .set(mailbox).equalToWhenPresent(row::getMailbox)
                        .set(pwdResetTime).equalToWhenPresent(row::getPwdResetTime)
                        .set(userId).equalToWhenPresent(row::getUserId)
                        .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                        .set(createTime).equalToWhenPresent(row::getCreateTime)
                        .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                        .where(id, isEqualTo(row::getId))
        );
    }
}
