package com.example.demo.service;

import com.example.demo.bean.role;
import com.example.demo.mapper.user_roleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName UserRoleService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/18 20:14
 * @Version 1.0
 */
@Service
public class UserRoleService  implements IUserRoleService{
    @Autowired
    private user_roleMapper user_roleMapper;
    @Override
    public Set<role> roles(String username) {
        return user_roleMapper.roles(username);
    }
}
