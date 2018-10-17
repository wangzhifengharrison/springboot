package com.todolist.demo.dao;

import com.todolist.demo.entity.Register;

import java.util.List;

public interface RegisterDao {
    /**
     * list register
     *
     * @return registerList
     */
    List<Register> queryRegister();

    /**
     * get register by Id
     *
     * @return Register
     */
    Register queryRegisterById(int registerId);

    /**
     * get register list by name
     *
     * @return Register
     */
    Register queryRegisterByName(String registerName);

    /**
     * insert register
     *
     * @param register
     * @return
     */
    int insertRegister(Register register);

    /**
     * update register
     *
     * @param register
     * @return
     */
    int updateRegister(Register register);

    /**
     * delete register by id
     *
     * @param registerId
     * @return
     */
    int deleteRegister(int registerId);
}
