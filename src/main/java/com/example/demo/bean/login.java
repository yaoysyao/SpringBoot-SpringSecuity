package com.example.demo.bean;


import org.springframework.stereotype.Component;

@Component
public class login {
    private String id;

    private String loginusername;

    private String loginpassword;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginusername() {
        return loginusername;
    }

    public void setLoginusername(String loginusername) {
        this.loginusername = loginusername == null ? null : loginusername.trim();
    }

    public String getLoginpassword() {
        return loginpassword;
    }

    public void setLoginpassword(String loginpassword) {
        this.loginpassword = loginpassword == null ? null : loginpassword.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}