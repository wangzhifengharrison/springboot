package com.todolist.demo.web.registeradmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*http://localhost:8080/demo2/registeradmin/registeroperation
*/
@Controller
@RequestMapping(value ="registeradmin",method = RequestMethod.GET)
public class RegisterAdminController {
	@RequestMapping(value ="registeroperation")
	public String registerOperation() {
		return "register/registeroperation";
		
	}
	
	@RequestMapping(value ="login")
	public String loginOperation() {
		return "register/login";
	}
	
	@RequestMapping(value ="index")
	public String indexOperation() {
		return "register/index";
	}
	
	@RequestMapping(value ="signup")
	public String signupOperation() {
		return "register/signup";
	}
	
	@RequestMapping(value ="task")
	public String taskOperation() {
		return "register/task";
	}
	
	@RequestMapping(value ="taskedit")
	public String taskeditOperation() {
		return "register/taskedit";
	}
	@RequestMapping(value ="taskadd")
	public String taskaddOperation() {
		return "register/taskadd";
	}

}
