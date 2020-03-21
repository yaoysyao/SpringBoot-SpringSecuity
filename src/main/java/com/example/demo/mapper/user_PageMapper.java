package com.example.demo.mapper;

import com.example.demo.bean.user_Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface user_PageMapper {
    int deleteByPrimaryKey(String id);

    int insert(user_Page record);

    int insertSelective(user_Page record);

    user_Page selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(user_Page record);

    int updateByPrimaryKey(user_Page record);

    List<user_Page> user_Page_List(@Param(value = "username") String userName);
}