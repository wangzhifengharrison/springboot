package com.todolist.demo.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.demo.dao.LoginDao;
import com.todolist.demo.entity.Login;
import com.todolist.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;
	@Override
	public List<Login> getLogin() {
		// TODO Auto-generated method stub
		 return loginDao.queryLogin();
	}

	@Override
	public Login getLoginById(int loginId) {
		// TODO Auto-generated method stub
		 return loginDao.queryLoginById(loginId);
	}

	@Override
	public Login getLoginByName(String loginName) {
		 return loginDao.queryLoginByName(loginName);
	}
	
	@Transactional
	@Override
	public boolean addLogin(Login login) {
		if (login.getLoginName() != null && !"".equals(login.getLoginName())) {
            try {
                int effectedNum = loginDao.insertLogin(login);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("error!");
                }
            } catch (Exception e) {
                throw new RuntimeException("error:" + e.toString());
            }
        } else {
            throw new RuntimeException("can not be null！");
        }
	}
    
	@Transactional
	@Override
	public boolean modifyLogin(Login login) {
		if (login.getLoginId() != null && login.getLoginId() > 0) {
            try {
                // update register
                int effectedNum = loginDao.updateLogin(login);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("error!");
                }
            } catch (Exception e) {
                throw new RuntimeException("error:" + e.toString());
            }
        } else {
            throw new RuntimeException("can not be null！");
        }
	}
    
	@Transactional
	@Override
	public boolean deleteLogin(int loginId) {
		if (loginId > 0) {
            try {
                // delete register
                int effectedNum = loginDao.deleteLogin(loginId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("error!");
                }
            } catch (Exception e) {
                throw new RuntimeException("error:" + e.toString());
            }
        } else {
            throw new RuntimeException("can not be null！");
        }
    }
	
}
