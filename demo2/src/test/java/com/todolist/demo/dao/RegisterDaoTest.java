package com.todolist.demo.dao;

import com.todolist.demo.BaseTest;
import com.todolist.demo.entity.Register;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static org.junit.Assert.*;
public class RegisterDaoTest extends BaseTest{

    @Autowired
    private RegisterDao registerDao;

    @Test
    @Ignore
 
    public void queryRegister() {
        List<Register> registerList = registerDao.queryRegister();
        assertEquals(3, registerList.size());
    }

    @Test
    @Ignore
    public void queryRegisterById() {
        Register register = registerDao.queryRegisterById(1);
        assertEquals("harrison", register.getRegisterName());
    }


    @Test
    @Ignore
    public void queryRegisterByName() {
        Register register = registerDao.queryRegisterByName("harrison");
        assertEquals("harrison", register.getRegisterName());
    }


    @Test
    @Ignore
    public void insertRegister() {
        Register register = new Register();
        register.setRegisterName("Jack");
        register.setRegisterPassword("Jack123");
        register.setRegisterRole("admin");
        //add register into database
        int effectedNum = registerDao.insertRegister(register);
        //test effected number in database
        assertEquals(1, effectedNum);
        List<Register> areaList = registerDao.queryRegister();
        assertEquals(4, areaList.size());
    }

    @Test
    @Ignore
    public void updateRegister() {
        List<Register> registerList = registerDao.queryRegister();
        for (Register register : registerList) {
            if ("harrison".equals(register.getRegisterName())) {
                // register password
                assertEquals("45", register.getRegisterPassword());
                register.setRegisterPassword("46");
                int effectedNum = registerDao.updateRegister(register);
                assertEquals(1, effectedNum);
            }
        }
    }

    @Test
    @Ignore
    public void deleteRegister() {
        List<Register> registerList = registerDao.queryRegister();
        for (Register register : registerList) {
            if ("Jack".equals(register.getRegisterName())) {
                int effectedNum = registerDao.deleteRegister(register.getRegisterId());
                assertEquals(1, effectedNum);
            }
        }
        registerList = registerDao.queryRegister();
        assertEquals(2, registerList.size());
    }
}
