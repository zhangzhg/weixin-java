package com.hsm.user.model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.framework.common.domain.BaseModel;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="sys_user")
@Where(clause="status > '0'")
public class SysUser extends BaseModel implements Serializable {
    @Column
    private String account;
    @Column
    @JsonIgnore
    private String password;
    @Column
    private String name;
    @Column
    @Size(max=50)
    private String wechatNo;

    @Column
    @Pattern(regexp="^[0-3]{1}$")
    private String status;

    @Column
    @Size(max=20)
    private String qq;

    @Column
    @Size(max=50)
    private String phone;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechatNo() {
        return wechatNo;
    }

    public void setWechatNo(String wechatNo) {
        this.wechatNo = wechatNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
