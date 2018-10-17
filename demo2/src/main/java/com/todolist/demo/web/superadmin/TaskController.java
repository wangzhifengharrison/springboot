package com.todolist.demo.web.superadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.todolist.demo.entity.Task;
import com.todolist.demo.service.TaskService;

@RestController
@RequestMapping("/superadmin")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/listtask", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listtask() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Task> list = new ArrayList<Task>();
		// get the list of login
		try {
			list = taskService.getTask();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());

		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}

		return modelMap;
	}

	@RequestMapping(value = "/gettaskbyid", method = RequestMethod.GET)
	private Map<String, Object> getTaskById(Integer taskId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// get register information
		Task task = taskService.getTaskById(taskId);
		modelMap.put("task", task);
		return modelMap;
	}

	@RequestMapping(value = "/gettaskbyname", method = RequestMethod.GET)
	private Map<String, Object> getTaskByName(String taskName) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// get register information
		Task task = taskService.getTaskByName(taskName);
		modelMap.put("task", task);
		return modelMap;
	}

	@RequestMapping(value = "/addtask", method = RequestMethod.POST)
	private Map<String, Object> addTask(@RequestBody Task task)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// insert register information
		modelMap.put("success", taskService.addTask(task));
		return modelMap;
	}

	@RequestMapping(value = "/modifytask", method = RequestMethod.POST)
	private Map<String, Object> modifyTask(@RequestBody Task task)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// modify register information
		modelMap.put("success", taskService.modifyTask(task));
		return modelMap;
	}

	@RequestMapping(value = "/removetask", method = RequestMethod.GET)
	private Map<String, Object> removeTask(Integer taskId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// delete register information
		modelMap.put("success", taskService.deleteTask(taskId));
		return modelMap;
	}

}
