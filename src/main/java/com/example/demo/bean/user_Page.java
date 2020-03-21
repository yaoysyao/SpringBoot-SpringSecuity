package com.example.demo.bean;


import org.springframework.stereotype.Component;

@Component
public class user_Page {
    private String id;

    private String userroleid;

    private String pageid;

    private String roleCode;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(String userroleid) {
        this.userroleid = userroleid == null ? null : userroleid.trim();
    }

    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid == null ? null : pageid.trim();
    }
}