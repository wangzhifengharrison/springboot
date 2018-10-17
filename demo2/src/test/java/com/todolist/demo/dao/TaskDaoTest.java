package com.todolist.demo.dao;

import com.todolist.demo.BaseTest;
import com.todolist.demo.entity.Task;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import static org.junit.Assert.*;
public class TaskDaoTest extends BaseTest{

    @Autowired
    private TaskDao taskDao;

    @Test
    public void queryTask() {
        List<Task> taskList = taskDao.queryTask();
        assertEquals(3, taskList.size());
    }

  
    @Test
    @Ignore

    public void insertTask() {
        Task task = new Task(); 
        task.setTaskName("wa");
        task.setProjectCode("ee");
        //add register into database
        int effectedNum = taskDao.insertTask(task);
        //test effected number in database
        assertEquals(1, effectedNum);
    }

    
}
