package com.zzq.learn_shiro_simple.model.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * 实体类。
 *
 * @author ZZQ
 * @since 1.0
 */
@Data
@Table(value = "user")
public class UserEntity {

    @Id(keyType = KeyType.Auto)
    private Long id;

    @Column(value = "nickname")
    private String nickname;

    @Column(value = "username")
    private String username;

    @Column(value = "tel")
    private String tel;

    @Column(value = "email")
    private String email;

    @Column(value = "password")
    private String password;

    @Column(value = "salt")
    private String salt;

    @Column(value = "create_time")
    private Long createTime;

    @Column(value = "update_time")
    private Long updateTime;


}
