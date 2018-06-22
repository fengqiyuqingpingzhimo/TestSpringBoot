package com.example.demo.mapper.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getUserList1();
    
    @Select("SELECT * FROM SYS_USER")
    List<User> getUserList();
    
    @Delete("DELETE FROM SYS_USER WHERE id =#{id}")
	void delete(String id);
    @Select("SELECT A.*,B.DWMC FROM SYS_USER A LEFT JOIN SYS_DWB B ON A.SSDW=B.GUID WHERE A.SSDW IS NOT NULL")
    List<Map<String, Object>> getUserDwList();
    
//    @Insert("INSERT INTO HYJ.SYS_USER (ID, LOGINNAME, PASSWORD,CREATETIME, BHPX, FLAG) VALUES (#{id},#{loginname},#{password},#{crearetime},#{bhpx},#{flag})")
    @Insert("INSERT INTO HYJ.SYS_USER (ID, LOGINNAME, PASSWORD,CREATETIME, BHPX, FLAG) VALUES (SYS_GUID(),#{loginname},#{password},#{createtime},#{bhpx},#{flag})")
    int annInsert(User record);
    //注意，使用#符号和$符号的不同：
   // This example creates a prepared statement, something like select * from teacher where name = ?;
   //@Select("Select * from teacher where name = #{name}")

    // This example creates n inlined statement, something like select * from teacher where name = 'someName';
   //@Select("Select * from teacher where name = '${name}'")
}