package com.example.demo.mapper;

import com.example.demo.bean.role;
import com.example.demo.bean.user_role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Mapper
public interface user_roleMapper {
    int deleteByPrimaryKey(String id);

    int insert(user_role record);

    int insertSelective(user_role record);

    user_role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(user_role record);

    int updateByPrimaryKey(user_role record);
    Set<role> roles (@Param(value = "username") String username);
}