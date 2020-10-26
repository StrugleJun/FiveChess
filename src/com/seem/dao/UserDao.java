package com.seem.dao;

import com.seem.bean.User;

public interface UserDao {

    /**
     * 用户登陆
     *      查询行为
     * @param userName
     * @param userPwd
     * @return
     */
    User userLogin(String userName, String userPwd);

    /**
     * 用户注册
     *      插入行为
     * @param userName
     * @param userPwd
     * @return
     */
    boolean userRegister(String userName,String userPwd);
}
