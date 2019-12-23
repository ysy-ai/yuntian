package com.yi.service.impl;

import com.yi.dao.UsersDao;
import com.yi.po.Users;
import com.yi.service.UsersService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersDao usersDao;
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    //查询用户所有信息
    @Override
    public Users selectUsers(Users users) {
        return usersDao.selectUsers(users).get(0);
    }

    //验证用户名
    @Override
    public boolean selectTel(Users users) {
        List<Users> users1 = usersDao.selectUsers(users);
        return users1.size() == 0;
    }

    //验证密码
    @Override
    public boolean selectPassword(Users users) {
        List<Users> users1 = usersDao.selectUsers(users);
        if (users1.size() != 0) {
            return users1.get(0).getTel().equals(users.getTel());
        }
        return false;
    }

    //注册
    @Override
    public void insertUsers(Users users) {
        usersDao.insertUsers(users);
    }

    //用户修改信息
    @Override
    public void updateUsers(Users users) {
        usersDao.updateUsers(users);
    }


}
