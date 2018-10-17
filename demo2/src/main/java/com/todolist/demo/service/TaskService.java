package com.todolist.demo.service;

import java.util.List;

import com.todolist.demo.entity.Task;

public interface TaskService {
	List<Task> getTask();
	Task getTaskById(int taskId);
	Task getTaskByName(String taskName);
    boolean addTask(Task task);
    boolean modifyTask(Task task);
    boolean deleteTask(int taskId);

}
