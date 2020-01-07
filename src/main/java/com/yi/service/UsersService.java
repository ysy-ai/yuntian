package com.yi.service;

import com.yi.po.Users;
/**
 * @author yisy
 */
public interface UsersService {
    /**
     * 查询用户信息
     * @param users 用户实体类
     * @return Users 用户实体类
     */
    Users selectUsers(Users users);
    /**
     * 登录
     * 验证用户名
     * @param users 用户实体类
     * @return boolean
     */
    boolean selectTel(Users users);
    /**
     * 验证密码
     * @param users 用户实体类
     * @return boolean
     */
    boolean selectPassword(Users users);
    /**
     * 注册
     * @param users 用户实体类
     */
    void insertUsers(Users users);
    /**
     * 用户修改信息
     * @param users 用户实体类
     */
    void updateUsers(Users users);
}
