package com.yi.dao;

import com.yi.po.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersDao {
    /**
     * 登录
     */
    List<Users> selectUsers(Users users);
    /**
     * 注册
     */
    void insertUsers(Users users);
    /**
     * 用户修改信息
     */
    void updateUsers(Users users);
}
