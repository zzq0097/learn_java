package com.zzq.learn.ago.learn.entity;

import jakarta.annotation.Generated;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SysUser implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long deptId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String deptName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String username;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String nickName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String phone;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String pass;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long initial;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean isAdmin;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean state;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long enabled;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String mailbox;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime pwdResetTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String updateBy;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getDeptId() {
        return deptId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getDeptName() {
        return deptName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNickName() {
        return nickName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPhone() {
        return phone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPass() {
        return pass;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getInitial() {
        return initial;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInitial(Long initial) {
        this.initial = initial;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getIsAdmin() {
        return isAdmin;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getState() {
        return state;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setState(Boolean state) {
        this.state = state;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getEnabled() {
        return enabled;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getMailbox() {
        return mailbox;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setMailbox(String mailbox) {
        this.mailbox = mailbox == null ? null : mailbox.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getPwdResetTime() {
        return pwdResetTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPwdResetTime(LocalDateTime pwdResetTime) {
        this.pwdResetTime = pwdResetTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUpdateBy() {
        return updateBy;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deptId=").append(deptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", username=").append(username);
        sb.append(", nickName=").append(nickName);
        sb.append(", phone=").append(phone);
        sb.append(", pass=").append(pass);
        sb.append(", initial=").append(initial);
        sb.append(", isAdmin=").append(isAdmin);
        sb.append(", state=").append(state);
        sb.append(", enabled=").append(enabled);
        sb.append(", mailbox=").append(mailbox);
        sb.append(", pwdResetTime=").append(pwdResetTime);
        sb.append(", userId=").append(userId);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
                && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
                && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
                && (this.getPass() == null ? other.getPass() == null : this.getPass().equals(other.getPass()))
                && (this.getInitial() == null ? other.getInitial() == null : this.getInitial().equals(other.getInitial()))
                && (this.getIsAdmin() == null ? other.getIsAdmin() == null : this.getIsAdmin().equals(other.getIsAdmin()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
                && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()))
                && (this.getMailbox() == null ? other.getMailbox() == null : this.getMailbox().equals(other.getMailbox()))
                && (this.getPwdResetTime() == null ? other.getPwdResetTime() == null : this.getPwdResetTime().equals(other.getPwdResetTime()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getPass() == null) ? 0 : getPass().hashCode());
        result = prime * result + ((getInitial() == null) ? 0 : getInitial().hashCode());
        result = prime * result + ((getIsAdmin() == null) ? 0 : getIsAdmin().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        result = prime * result + ((getMailbox() == null) ? 0 : getMailbox().hashCode());
        result = prime * result + ((getPwdResetTime() == null) ? 0 : getPwdResetTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
