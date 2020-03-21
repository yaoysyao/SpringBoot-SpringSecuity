package com.example.demo.mapper;

import com.example.demo.bean.page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface pageMapper {
    int deleteByPrimaryKey(String id);

    int insert(page record);

    int insertSelective(page record);

    page selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(page record);

    int updateByPrimaryKey(page record);
}