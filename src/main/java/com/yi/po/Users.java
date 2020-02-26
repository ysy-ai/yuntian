package com.yi.po;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author yisy
 * 用户实体类
 */
public class Users{
    private int id;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 昵称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    private String passwords;
    /**
     * 头像
     */
    private String headPortrait;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 用户标识  0：普通用户  1：商家
     */
    private String status;


    public Users(){}

    public Users(int id, String tel, String username, String password, String passwords,String headPortrait, String birthday, String status) {
        this.id = id;
        this.tel = tel;
        this.username = username;
        this.password = password;
        this.passwords = passwords;
        this.headPortrait = headPortrait;
        this.birthday = birthday;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwords='" + passwords + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", birthday='" + birthday + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

