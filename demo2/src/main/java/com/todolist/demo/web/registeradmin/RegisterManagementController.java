package com.todolist.demo.web.registeradmin;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.demo.entity.Register;
import com.todolist.demo.service.RegisterService;
import com.todolist.demo.util.HttpServletRequestUtil;

@Controller
@RequestMapping("/registeremployeeadmin")
public class RegisterManagementController {
	@Autowired
	private RegisterService registerService;
	@RequestMapping(value ="/registeremployee",method = RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> Registeremployee(HttpServletRequest request){
		Map<String,Object> modelMap = new HashMap<String,Object>();
		
		//1. get the parameters and employee information
		String registerStr =HttpServletRequestUtil.getString(request, "registerStr");
		ObjectMapper mapper = new ObjectMapper();
		Register register = null;
		try {
			register =mapper.readValue(registerStr, Register.class);
		}catch(Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		//use commonsMutilpartfile to get image
		//2 register employee
		if(register!=null) {
			 modelMap.put("success", registerService.addRegister(register));
		}else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "please fill the employee information");
			return modelMap;
		}
		//3. return result
		return modelMap;
	}

}
