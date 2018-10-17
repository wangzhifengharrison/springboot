package com.todolist.demo.entity;

import java.util.Date;

public class Task {
	private Integer taskId;
	private String taskName;
	private String projectCode;
	private String taskDescription;
	private Date taskDuedate;
	private Date taskCreatedate;
	
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public Date getTaskDuedate() {
		return taskDuedate;
	}
	public void setTaskDuedate(Date taskDuedate) {
		this.taskDuedate = taskDuedate;
	}
	public Date getTaskCreatedate() {
		return taskCreatedate;
	}
	public void setTaskCreatedate(Date taskCreatedate) {
		this.taskCreatedate = taskCreatedate;
	}
	
	
	
}
