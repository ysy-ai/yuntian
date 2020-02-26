package com.yi.dao;

import com.yi.po.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86132
 */
@Mapper
@Repository
public interface UsersDao {
    /**
     * 登录
     * @param users 用户实体类
     * @return Users 用户实体类
     */
    List<Users> selectTel(Users users);
    Users selectUsers(Users users);
    Users selectUsername(Users users);
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
    /**
     * 用户注销
     * @param tel 电话
     */
    void deleteUser(String tel);
}
