package com.todolist.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.todolist.demo.dao.TaskDao;
import com.todolist.demo.entity.Task;
import com.todolist.demo.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private TaskDao taskDao;
	@Override
	public List<Task> getTask() {
		// TODO Auto-generated method stub
		return taskDao.queryTask();
	}

	@Override
	public Task getTaskById(int taskId) {
		// TODO Auto-generated method stub
		return taskDao.queryTaskById(taskId);
	}

	@Override
	public Task getTaskByName(String taskName) {
		// TODO Auto-generated method stub
		return taskDao.queryTaskByName(taskName);
	}
	
	
	@Transactional
	@Override
	public boolean addTask(Task task) {
		// TODO Auto-generated method stub
		if (task.getTaskName() != null && !"".equals(task.getTaskName())) {
            try {
                int effectedNum = taskDao.insertTask(task);
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
	public boolean modifyTask(Task task) {
		// TODO Auto-generated method stub
		if (task.getTaskId() != null && task.getTaskId() > 0) {
            try {
                // update register
                int effectedNum = taskDao.updateTask(task);
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
	public boolean deleteTask(int taskId) {
		if (taskId > 0) {
            try {
                // delete register
                int effectedNum = taskDao.deleteTask(taskId);
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
