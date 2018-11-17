package com.hsm.user.model.model;

import com.framework.common.domain.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="sys_user")
public class SysMenu extends BaseModel implements Serializable {
    @Column
    private String parentId;
    //权限类型 MENU:菜单 OPERATE:操作
    @Column
    private String type;
    //权限编码
    @Column
    private String code;
    //权限名称
    @Column
    private String name;
    //连接地址
    @Column
    private String url;
    //层级
    @Column
    private Integer lv;
    //是否是叶子节点 1.是 0.不是
    @Column
    private Boolean leaf;
    //排序号
    @Column
    private Integer sortNum;
    //图标
    @Column
    private String icon;
    //是否显示 1.显示 0.不显示
    @Column
    private String display;
    //备注
    @Column
    private String remark;
    //创建人
    @Column
    private String createUser;
    //创建时间
    @Column
    private Date createTime;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
