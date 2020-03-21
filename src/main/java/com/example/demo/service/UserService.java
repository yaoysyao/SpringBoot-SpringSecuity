package com.example.demo.service;

import com.example.demo.bean.role;
import com.example.demo.bean.user;
import com.example.demo.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/18 19:50
 * @Version 1.0
 */
@Service
public class UserService implements UserServiceImpl{

    @Autowired
    private userMapper userMapper;


    @Override
    public user findUserByUsername(String username) {

        return userMapper.findUserByUsername(username);
    }
}
