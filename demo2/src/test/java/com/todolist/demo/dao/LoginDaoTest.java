package com.todolist.demo.dao;

import com.todolist.demo.BaseTest;
import com.todolist.demo.entity.Login;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static org.junit.Assert.*;
public class LoginDaoTest extends BaseTest{

    @Autowired
    private LoginDao loginDao;

    @Test
    @Ignore
 
    public void queryLogin() {
        List<Login> loginList = loginDao.queryLogin();
        assertEquals(3, loginList.size());
    }

  
    @Test

    public void insertLogin() {
        Login login = new Login();
   
        login.setLoginName("wa");
        login.setLoginPassword("we");
        //add register into database
        int effectedNum = loginDao.insertLogin(login);
        //test effected number in database
        assertEquals(1, effectedNum);
    }

    
}
