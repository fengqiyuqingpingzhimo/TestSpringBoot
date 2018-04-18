package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.example.demo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);
    List<User> getUserList();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Delete("DELETE FROM USERT WHERE id =#{id}")
	void delete(String id);
    //注意，使用#符号和$符号的不同：
   // This example creates a prepared statement, something like select * from teacher where name = ?;
   //@Select("Select * from teacher where name = #{name}")

    // This example creates n inlined statement, something like select * from teacher where name = 'someName';
   //@Select("Select * from teacher where name = '${name}'")
}