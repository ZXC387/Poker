package cn.run.domain;

import java.io.Serializable;

public class User implements Serializable {

    private int uid;
    private String username;
    private String password;//密码
    private String real_name;//真实姓名
    private String regist_time;//注册日期
    private String sex;//男或女
    private String telephone;//手机号
    private String email;//邮箱
    private String address;//地址
    private String status;//激活状态，Y代表激活，N代表未激活
    private String code;//激活码（要求唯一）

    public User() {

    }

    public User(int uid, String username, String password, String real_name, String regist_time, String sex, String telephone, String email, String address, String status,String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.real_name = real_name;
        this.regist_time = regist_time;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.code = code;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
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

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getRegist_time() {
        return regist_time;
    }

    public void setRegist_time(String regist_time) {
        this.regist_time = regist_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
