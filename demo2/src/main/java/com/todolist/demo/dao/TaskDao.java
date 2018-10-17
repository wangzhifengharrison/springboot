package com.todolist.demo.dao;

import java.util.List;

import com.todolist.demo.entity.Task;

public interface TaskDao {
	List<Task> queryTask();
	Task queryTaskById(int taskId);
	Task queryTaskByName(String taskName);
    int insertTask(Task task);
    int updateTask(Task task);
    int deleteTask(int taskId);
}
