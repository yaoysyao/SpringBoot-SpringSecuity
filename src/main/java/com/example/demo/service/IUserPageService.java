package com.example.demo.service;

import com.example.demo.bean.user_Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName IUserPageService
 * @Description TODO
 * @Author YYS
 * @Date 2020/3/19 22:10
 * @Version 1.0
 */
@Service
public interface IUserPageService {
    List<user_Page> user_Page_List(String usrname);
}
