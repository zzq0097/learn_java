package com.zzq.learn.ago.learn.mapper;

import com.zzq.learn.ago.learn.entity.SysDept;
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

import static com.zzq.learn.ago.learn.mapper.SysDeptDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface SysDeptMapper extends CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(id, pId, deptName, levelName, deptDesc, state, userId, updateBy, createTime, updateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "row.id")
    int insert(InsertStatementProvider<SysDept> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultipleWithGeneratedKeys")
    @Options(useGeneratedKeys = true, keyProperty = "records.id")
    int insertMultiple(@Param("insertStatement") String insertStatement, @Param("records") List<SysDept> records);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "SysDeptResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "p_id", property = "pId", jdbcType = JdbcType.BIGINT),
            @Result(column = "dept_name", property = "deptName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "level_name", property = "levelName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dept_desc", property = "deptDesc", jdbcType = JdbcType.VARCHAR),
            @Result(column = "state", property = "state", jdbcType = JdbcType.BIGINT),
            @Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            @Result(column = "update_by", property = "updateBy", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "update_time", property = "updateTime", jdbcType = JdbcType.TIMESTAMP)
    })
    List<SysDept> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("SysDeptResult")
    Optional<SysDept> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysDept, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysDept, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(SysDept row) {
        return MyBatis3Utils.insert(this::insert, row, sysDept, c ->
                c.map(pId).toProperty("pId")
                        .map(deptName).toProperty("deptName")
                        .map(levelName).toProperty("levelName")
                        .map(deptDesc).toProperty("deptDesc")
                        .map(state).toProperty("state")
                        .map(userId).toProperty("userId")
                        .map(updateBy).toProperty("updateBy")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<SysDept> records) {
        return MyBatis3Utils.insertMultipleWithGeneratedKeys(this::insertMultiple, records, sysDept, c ->
                c.map(pId).toProperty("pId")
                        .map(deptName).toProperty("deptName")
                        .map(levelName).toProperty("levelName")
                        .map(deptDesc).toProperty("deptDesc")
                        .map(state).toProperty("state")
                        .map(userId).toProperty("userId")
                        .map(updateBy).toProperty("updateBy")
                        .map(createTime).toProperty("createTime")
                        .map(updateTime).toProperty("updateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(SysDept row) {
        return MyBatis3Utils.insert(this::insert, row, sysDept, c ->
                c.map(pId).toPropertyWhenPresent("pId", row::getpId)
                        .map(deptName).toPropertyWhenPresent("deptName", row::getDeptName)
                        .map(levelName).toPropertyWhenPresent("levelName", row::getLevelName)
                        .map(deptDesc).toPropertyWhenPresent("deptDesc", row::getDeptDesc)
                        .map(state).toPropertyWhenPresent("state", row::getState)
                        .map(userId).toPropertyWhenPresent("userId", row::getUserId)
                        .map(updateBy).toPropertyWhenPresent("updateBy", row::getUpdateBy)
                        .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
                        .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysDept> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysDept, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysDept> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysDept, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<SysDept> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysDept, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<SysDept> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
                c.where(id, isEqualTo(id_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysDept, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(SysDept row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pId).equalTo(row::getpId)
                .set(deptName).equalTo(row::getDeptName)
                .set(levelName).equalTo(row::getLevelName)
                .set(deptDesc).equalTo(row::getDeptDesc)
                .set(state).equalTo(row::getState)
                .set(userId).equalTo(row::getUserId)
                .set(updateBy).equalTo(row::getUpdateBy)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateTime).equalTo(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysDept row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(pId).equalToWhenPresent(row::getpId)
                .set(deptName).equalToWhenPresent(row::getDeptName)
                .set(levelName).equalToWhenPresent(row::getLevelName)
                .set(deptDesc).equalToWhenPresent(row::getDeptDesc)
                .set(state).equalToWhenPresent(row::getState)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(SysDept row) {
        return update(c ->
                c.set(pId).equalTo(row::getpId)
                        .set(deptName).equalTo(row::getDeptName)
                        .set(levelName).equalTo(row::getLevelName)
                        .set(deptDesc).equalTo(row::getDeptDesc)
                        .set(state).equalTo(row::getState)
                        .set(userId).equalTo(row::getUserId)
                        .set(updateBy).equalTo(row::getUpdateBy)
                        .set(createTime).equalTo(row::getCreateTime)
                        .set(updateTime).equalTo(row::getUpdateTime)
                        .where(id, isEqualTo(row::getId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(SysDept row) {
        return update(c ->
                c.set(pId).equalToWhenPresent(row::getpId)
                        .set(deptName).equalToWhenPresent(row::getDeptName)
                        .set(levelName).equalToWhenPresent(row::getLevelName)
                        .set(deptDesc).equalToWhenPresent(row::getDeptDesc)
                        .set(state).equalToWhenPresent(row::getState)
                        .set(userId).equalToWhenPresent(row::getUserId)
                        .set(updateBy).equalToWhenPresent(row::getUpdateBy)
                        .set(createTime).equalToWhenPresent(row::getCreateTime)
                        .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                        .where(id, isEqualTo(row::getId))
        );
    }
}
