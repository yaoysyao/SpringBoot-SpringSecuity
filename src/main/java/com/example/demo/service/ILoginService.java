package com.example.demo.service;

import com.example.demo.bean.login;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @ClassName ILoginService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/19 22:33
 * @Version 1.0
 */
@Service
public interface ILoginService {
    login getLoginByUserName( String username);
}
