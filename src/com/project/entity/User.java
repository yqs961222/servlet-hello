package com.project.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 1> 基本
 * 类名--表名
 * 属性--列名
 * 对象-->一行数据(记录)
 * 2> 条件
 * 1> 实现序列化接口
 * 2> 使用包装类型
 * 3> 属性私有化,提供getter setter方法
 * 4> 提供无参的构造方法
 *
 */
public class User implements Serializable {
    private String username;
    private String password;
    private Integer uid;
//    private String phone;
//    private String email;
//    private Timestamp createDate;
//    private Integer isDel;

    public User() {
    }

   /* public User(String username, String password, Integer uid, String phone, String email, Timestamp createDate, Integer isDel) {
        this.username = username;
        this.password = password;
        this.uid = uid;
        this.phone = phone;
        this.email = email;
        this.createDate = createDate;
        this.isDel = isDel;
    }*/

    public User(String username, String password, Integer uid) {
        this.username = username;
        this.password = password;
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
