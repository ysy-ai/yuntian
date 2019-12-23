package com.yi.service;

import com.yi.po.Users;

import java.util.List;

public interface UsersService {
    //查询用户信息
    Users selectUsers(Users users);
    //登录
    //验证用户名
    boolean selectTel(Users users);
    //验证密码
    boolean selectPassword(Users users);

    //注册
    void insertUsers(Users users);

    //用户修改信息
    void updateUsers(Users users);
}
