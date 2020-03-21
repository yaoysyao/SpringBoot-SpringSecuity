package com.example.demo.mapper;

import com.example.demo.bean.login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface loginMapper {
    int deleteByPrimaryKey(String id);

    int insert(login record);

    int insertSelective(login record);

    login selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(login record);

    int updateByPrimaryKey(login record);

    login getLoginByUserName(@Param(value = "username") String username);
}