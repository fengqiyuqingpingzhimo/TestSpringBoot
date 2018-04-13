package com.example.demo.mapper;

import java.util.List;

import com.example.demo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);
    List<User> getUserList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}