package com.example.demo.service;

import com.example.demo.bean.role;
import com.example.demo.bean.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/18 19:50
 * @Version 1.0
 */
@Service
public interface UserServiceImpl {
    user findUserByUsername(String username);
}
