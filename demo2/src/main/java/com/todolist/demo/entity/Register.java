package com.todolist.demo.entity;

public class Register {
    private Integer registerId;
    private String registerName;
    private String registerPassword;
    private String registerRole;

    public Integer getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

    public String getRegisterRole() {
        return registerRole;
    }

    public void setRegisterRole(String registerRole) {
        this.registerRole = registerRole;
    }
}
