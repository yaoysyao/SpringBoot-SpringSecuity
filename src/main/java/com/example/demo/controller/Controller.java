package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName Controller
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/17 21:38
 * @Version 1.0
 */
@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/index"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/index1"})
    public String index1() {
        return "index1";
    }

    @RequestMapping({"/index2"})
    public String index2() {
        return "index2";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

    @RequestMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
    }

}
