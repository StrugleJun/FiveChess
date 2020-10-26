package com.seem.dao.impl;

import com.seem.bean.User;
import com.seem.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public User userLogin(String userName, String userPwd) {
        return null;
    }

    @Override
    public boolean userRegister(String userName, String userPwd) {
        return false;
    }
}
