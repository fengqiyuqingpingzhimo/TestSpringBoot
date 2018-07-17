package com.example.demo.mapper.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.example.demo.model.User;
/**
* @Title: UserMapper.java  
* @Package com.example.demo.mapper.dao  
* @Description: TODO
* @author wdm  
* @date 2018年6月25日  上午10:22:26
* @version V1.0
* 关于spring配置缓存相关问题   resources/static/option/Cache注解详解
 */
@CacheConfig(cacheNames = "users")//配置了该数据访问对象中返回的内容将存储于名为users的缓存对象中
public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);
    
    @Cacheable(key ="#p0")//将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。  //spel表达式
    User selectByPrimaryKey(String id);
    
    @Select("SELECT * FROM SYS_USER WHERE LOGINNAME=#{0}")
    User selectByLoginName(String loginname);
    
//    @CachePut(key="'ot6r2g72fyCdGSLa0tyJmo4g4XiKqp4A'")
//    @CachePut( key = "#p0.id") 
//    @Cacheable(key ="'cs_'+#p0.id")
    @CacheEvict(key ="#p0.id",allEntries=false)
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> getUserList1();
    
    @Select("SELECT * FROM SYS_USER")
    List<User> getUserList();
    
    @Delete("DELETE FROM SYS_USER WHERE id =#{id}")
    @CacheEvict(key ="#p0",allEntries=false)//如果指定为 true，则方法调用后将立即清空所有缓存
	void delete(String id);
    
    @Select("SELECT A.*,B.DWMC FROM SYS_USER A LEFT JOIN SYS_DWB B ON A.SSDW=B.GUID WHERE A.SSDW IS NOT NULL")
    List<Map<String, Object>> getUserDwList();
    
//    @Insert("INSERT INTO HYJ.SYS_USER (ID, LOGINNAME, PASSWORD,CREATETIME, BHPX, FLAG) VALUES (#{id},#{loginname},#{password},#{crearetime},#{bhpx},#{flag})")
    @Insert("INSERT INTO SYS_USER (ID, LOGINNAME, PASSWORD,CREATETIME, BHPX, FLAG,SSDW) VALUES (SYS_GUID(),#{loginname},#{password},#{createtime},#{bhpx},#{flag},#{ssdw})")
    int annInsert(User record);
    
    @Update("UPDATE SYS_USER SET SSDW=#{0} WHERE ID=#{1}")
    int annUpdate(String ssdw,String id);
    
    @Select("SELECT * FROM SYS_USER WHERE ID=#{id}")
    @Cacheable(key ="#p0")//将查询结果缓存到redis中,（key="#p0"）指定传入的第一个参数作为redis的key。
    User annSelectByPrimaryKey(@Param("id") String id);
    //注意，使用#符号和$符号的不同：
   // This example creates a prepared statement, something like select * from teacher where name = ?;
   //@Select("Select * from teacher where name = #{name}")

    // This example creates n inlined statement, something like select * from teacher where name = 'someName';
   //@Select("Select * from teacher where name = '${name}'")
}