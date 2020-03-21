package com.example.demo.service;

import com.example.demo.bean.role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @ClassName IUserRoleService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/18 20:14
 * @Version 1.0
 */
@Service
public interface IUserRoleService {
    Set<role> roles (@Param(value = "username") String username);
}
