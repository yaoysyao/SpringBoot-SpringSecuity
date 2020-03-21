package com.example.demo.service;

import com.example.demo.bean.login;
import com.example.demo.mapper.loginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/19 22:34
 * @Version 1.0
 */
@Service
public class LoginService implements ILoginService {
    @Autowired
    loginMapper loginMapper;


    @Override
    public login getLoginByUserName(String username) {
        return loginMapper.getLoginByUserName(username);
    }
}
