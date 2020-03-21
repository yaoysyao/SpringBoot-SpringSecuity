package com.example.demo.mapper;

import com.example.demo.bean.role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Mapper
public interface roleMapper {
    int deleteByPrimaryKey(String id);

    int insert(role record);

    int insertSelective(role record);

    role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
    Set<role> roles (@Param(value = "username") String username);
}