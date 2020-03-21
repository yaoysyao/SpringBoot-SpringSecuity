package com.example.demo.service;

import com.example.demo.bean.user_Page;
import com.example.demo.mapper.user_PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserPageService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/19 22:12
 * @Version 1.0
 */
@Service
public class UserPageService  implements IUserPageService{

    @Autowired
    user_PageMapper user_pageMapper;
    @Override
    public List<user_Page> user_Page_List(String username) {

        return user_pageMapper.user_Page_List(username);
    }
}
