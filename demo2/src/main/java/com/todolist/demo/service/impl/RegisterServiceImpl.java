package com.todolist.demo.service.impl;

import com.todolist.demo.dao.RegisterDao;
import com.todolist.demo.entity.Register;
import com.todolist.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;

    @Override
    public List<Register> getRegister() {
        // return all register information
        return registerDao.queryRegister();
    }

    @Override
    public Register getRegisterById(int registerId) {
        return registerDao.queryRegisterById(registerId);
    }

    @Override
    public Register getRegisterByName(String registerName) {
        return registerDao.queryRegisterByName(registerName);
    }

    @Transactional
    @Override
    public boolean addRegister(Register register) {

        if (register.getRegisterName() != null && !"".equals(register.getRegisterName())) {
            try {
                int effectedNum = registerDao.insertRegister(register);
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
    public boolean modifyRegister(Register register) {

        if (register.getRegisterId() != null && register.getRegisterId() > 0) {
            try {
                // update register
                int effectedNum = registerDao.updateRegister(register);
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
    public boolean deleteRegister(int registerId) {
        if (registerId > 0) {
            try {
                // delete register
                int effectedNum = registerDao.deleteRegister(registerId);
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