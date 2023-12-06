package com.zzq.learn.ago.learn.dao.base;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.zzq.learn.ago.learn.controller.base.PageResult;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//@Slf4j
@Component
public abstract class BaseDao<T> {
    @Resource
    private JdbcTemplate jdbcTemplate;
    private String tableName;
    private BeanPropertyRowMapper<T> tBean;

    public BaseDao() {
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            @SuppressWarnings("unchecked")
            Class<T> clazz = (Class<T>) typeArguments[0];
            this.tableName = StrUtil.toUnderlineCase(clazz.getSimpleName());
            this.tBean = new BeanPropertyRowMapper<>(clazz);
        }
    }

    public int insert(T t) {
        if (t == null) return 0;
        StringBuilder key = new StringBuilder();
        StringBuilder val = new StringBuilder();
        List<Object> args = new ArrayList<>();
        for (Field field : ReflectUtil.getFields(t.getClass())) {
            String k = ReflectUtil.getFieldName(field);
            Object v = ReflectUtil.getFieldValue(t, k);
            if (v == null) continue;
            key.append(",").append("`").append(StrUtil.toUnderlineCase(k)).append("`");
            val.append(",").append("?");
            args.add(v);
        }
        if (key.length() < 1) return 0;
        key.deleteCharAt(0);
        val.deleteCharAt(0);
        String sql = "INSERT INTO " + tableName + " (" + key + ") VALUES (" + val + ")";
//        log.info("[{}] - insertSql: {}",tableName,sql);
        return jdbcTemplate.update(sql, args.toArray());
    }

    public int update(T t) {
        Object id = ReflectUtil.getFieldValue(t, "id");
        if (t == null || id == null) return 0;
        StringBuilder content = new StringBuilder();
        for (Field field : ReflectUtil.getFields(t.getClass())) {
            String k = ReflectUtil.getFieldName(field);
            Object v = ReflectUtil.getFieldValue(t, k);
            if (v == null || k.equals("id")) continue;
            content.append(",").append(StrUtil.toUnderlineCase(k)).append("=").append("\"").append(v).append("\"");
        }
        if (content.length() < 1) return 0;
        content.deleteCharAt(0);
        String sql = "UPDATE " + tableName + " SET " + content + " WHERE id=" + id;
//        log.info("[{}] - updateSql: {}",tableName,sql);
        return jdbcTemplate.update(sql);
    }

    public int del(Integer id) {
        String sql = "DELETE FROM " + tableName + " WHERE id=" + id;
//        log.info("[{}] - deleteSql: {}",tableName,sql);
        return jdbcTemplate.update(sql);
    }

    public T selectById(Integer id) {
        String sql = "SELECT * FROM " + tableName + " WHERE id=" + id;
//        log.info("[{}] - selectSql: {}",tableName,sql);
        return jdbcTemplate.queryForObject(sql, tBean);
    }

    public PageResult<T> page(Integer page, Integer pageSize) {
        String countSql = "SELECT count(*) FROM " + tableName;
        String pageSql = "SELECT * FROM " + tableName + " LIMIT " + pageSize * (page - 1) + "," + pageSize;
//        log.info("[{}] - countSql: {}",tableName,countSql);
//        log.info("[{}] - pageSql: {}",tableName,pageSql);
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setTotal(jdbcTemplate.queryForObject(countSql, Integer.class));
        pageResult.setList(jdbcTemplate.query(pageSql, tBean));
        return pageResult;
    }

    public List<T> listByField(String field, String value) {
        String sql = "SELECT * FROM " + tableName + " WHERE `" + field + "`=\"" + value + "\"";
//        log.info("[{}] - listSql: {}",tableName,sql);
        return jdbcTemplate.query(sql, tBean);
    }

}
