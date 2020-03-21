package com.example.demo.service;

import com.example.demo.bean.role;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @ClassName IRoleService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/18 20:19
 * @Version 1.0
 */
public interface IRoleService {
    Set<role> roles (@Param(value = "username") String username);
}
