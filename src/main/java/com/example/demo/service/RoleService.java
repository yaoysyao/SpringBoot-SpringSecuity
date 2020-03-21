package com.example.demo.service;

import com.example.demo.bean.role;
import com.example.demo.mapper.roleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName RoleService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/18 20:19
 * @Version 1.0
 */
@Service
public class RoleService implements IRoleService{


    @Autowired
    private roleMapper roleMapper;

    @Override
    public Set<role> roles(String username) {
        return roleMapper.roles(username);
    }
}
