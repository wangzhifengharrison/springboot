package com.todolist.demo.service;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.todolist.demo.BaseTest;
import com.todolist.demo.entity.Register;

public class RegisterserviceTest extends BaseTest{
@Autowired
private RegisterService registerService;
@Test
public void testgetRegister() {
	List<Register> registerList = registerService.getRegister();
	 assertEquals("harrison", registerList.get(0).getRegisterName());
}
}
