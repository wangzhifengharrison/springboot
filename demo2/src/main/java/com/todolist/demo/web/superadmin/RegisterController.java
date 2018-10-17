package com.todolist.demo.web.superadmin;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.todolist.demo.entity.Register;
import com.todolist.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    /**
     * get all the register information
     *
     * @return
     */
    @RequestMapping(value = "/listregister", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listregister() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Register> list = new ArrayList<Register>();
        // get the list of register
        try {
        	   list = registerService.getRegister();
               modelMap.put("rows", list);
               modelMap.put("total", list.size());
        	
        }catch(Exception e) {
        	e.printStackTrace();
        	modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
     
        return modelMap;
    }

    /**
     * get register information by id
     *
     * @return
     */
    @RequestMapping(value = "/getregisterbyid", method = RequestMethod.GET)
    private Map<String, Object> getRegisterById(Integer registerId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // get register information
        Register register = registerService.getRegisterById(registerId);
        modelMap.put("register", register);
        return modelMap;
    }


    /**
     * get register information by name
     *
     * @return
     */
    @RequestMapping(value = "/getregisterbyname", method = RequestMethod.GET)
    private Map<String, Object> getRegisterByEmail(String registerName) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // get register information
        Register register = registerService.getRegisterByName(registerName);
        modelMap.put("register", register);
        return modelMap;
    }


    /**
     * insert register information
     *
     * @param register
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addregister", method = RequestMethod.POST)
    private Map<String, Object> addRegister(@RequestBody Register register)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // insert register information
        modelMap.put("success", registerService.addRegister(register));
        return modelMap;
    }

    /**
     * modify register information
     *
     * @param register
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyregister", method = RequestMethod.POST)
    private Map<String, Object> modifyRegister(@RequestBody Register register)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // modify register information
        modelMap.put("success", registerService.modifyRegister(register));
        return modelMap;
    }

    /**
     * delete register information by Id
     *
     * @return
     */

    @RequestMapping(value = "/removeregister", method = RequestMethod.GET)
    private Map<String, Object> removeRegister(Integer registerID) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // delete register information
        modelMap.put("success", registerService.deleteRegister(registerID));
        return modelMap;
    }

}