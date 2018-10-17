package com.todolist.demo.dao;

import java.util.List;

import com.todolist.demo.entity.Login;
public interface LoginDao {
    List<Login> queryLogin();
    Login queryLoginById(int loginId);
    Login queryLoginByName(String loginName);
    int insertLogin(Login login);
    int updateLogin(Login login);
    int deleteLogin(int loginId);
}
