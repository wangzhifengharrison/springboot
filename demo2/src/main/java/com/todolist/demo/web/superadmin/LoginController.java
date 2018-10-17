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
import com.todolist.demo.entity.Login;
import com.todolist.demo.service.LoginService;

@RestController
@RequestMapping("/superadmin")
public class LoginController {
	 @Autowired
	 private LoginService loginService;

	@RequestMapping(value = "/listlogin", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listlogin() {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Login> list = new ArrayList<Login>();
		// get the list of login
		try {
			list = loginService.getLogin();
			modelMap.put("rows", list);
			modelMap.put("total", list.size());

		} catch (Exception e) {
			e.printStackTrace();
			modelMap.put("success", false);
			modelMap.put("errMsg", e.toString());
		}

		return modelMap;
	}

	    @RequestMapping(value = "/getloginbyid", method = RequestMethod.GET)
	    private Map<String, Object> getLoginById(Integer loginId) {
	        Map<String, Object> modelMap = new HashMap<String, Object>();
	        // get register information
	        Login login = loginService.getLoginById(loginId);
	        modelMap.put("login", login);
	        return modelMap;
	    }

	    @RequestMapping(value = "/getloginbyname", method = RequestMethod.GET)
	    private Map<String, Object> getLoginByName(String loginName) {
	        Map<String, Object> modelMap = new HashMap<String, Object>();
	        // get register information
	        Login login = loginService.getLoginByName(loginName);
	        modelMap.put("login", login);
	        return modelMap;
	    }

	    @RequestMapping(value = "/addlogin", method = RequestMethod.POST)
	    private Map<String, Object> addLogin(@RequestBody Login login)
	            throws JsonParseException, JsonMappingException, IOException {
	        Map<String, Object> modelMap = new HashMap<String, Object>();
	        // insert register information
	        modelMap.put("success", loginService.addLogin(login));
	        return modelMap;
	    }

	    @RequestMapping(value = "/modifylogin", method = RequestMethod.POST)
	    private Map<String, Object> modifyLogin(@RequestBody Login login)
	            throws JsonParseException, JsonMappingException, IOException {
	        Map<String, Object> modelMap = new HashMap<String, Object>();
	        // modify register information
	        modelMap.put("success", loginService.modifyLogin(login));
	        return modelMap;
	    }

	    @RequestMapping(value = "/removelogin", method = RequestMethod.GET)
	    private Map<String, Object> removeLogin(Integer loginId) {
	        Map<String, Object> modelMap = new HashMap<String, Object>();
	        // delete register information
	        modelMap.put("success", loginService.deleteLogin(loginId));
	        return modelMap;
	    }

}
