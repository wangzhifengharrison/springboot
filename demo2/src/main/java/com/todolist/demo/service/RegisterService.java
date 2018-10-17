package com.todolist.demo.service;

import java.util.List;

import com.todolist.demo.entity.Register;

public interface RegisterService {
	 /**
     * list register
     *
     * @return registerList
     */
    List<Register> getRegister();

    /**
     * get register by Id
     *
     * @return Register
     */
    Register getRegisterById(int registerId);

    /**
     * get register by name
     *
     * @return Register
     */
    Register getRegisterByName(String registerName);

    /**
     * insert register
     *
     * @param register
     * @return
     */
    boolean addRegister(Register register);

    /**
     * update register
     *
     * @param register
     * @return
     */
    boolean modifyRegister(Register register);

    /**
     * delete register
     *
     * @param registerId
     * @return
     */
    boolean deleteRegister(int registerId);

}
