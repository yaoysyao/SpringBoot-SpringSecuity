package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component
public class role {
    private String id;

    private String rolename;

    private String roleremark;

    private login login;
    private user_role user_role;

    public com.example.demo.bean.login getLogin() {
        return login;
    }

    public void setLogin(com.example.demo.bean.login login) {
        this.login = login;
    }

    public com.example.demo.bean.user_role getUser_role() {
        return user_role;
    }

    public void setUser_role(com.example.demo.bean.user_role user_role) {
        this.user_role = user_role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRoleremark() {
        return roleremark;
    }

    public void setRoleremark(String roleremark) {
        this.roleremark = roleremark == null ? null : roleremark.trim();
    }
}