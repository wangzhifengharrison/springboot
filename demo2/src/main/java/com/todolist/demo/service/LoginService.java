package com.todolist.demo.service;

import java.util.List;

import com.todolist.demo.entity.Login;

public interface LoginService {
    List<Login> getLogin();
    Login getLoginById(int loginId);
    Login getLoginByName(String loginName);
    boolean addLogin(Login login);
    boolean modifyLogin(Login login);
    boolean deleteLogin(int loginId);
}
