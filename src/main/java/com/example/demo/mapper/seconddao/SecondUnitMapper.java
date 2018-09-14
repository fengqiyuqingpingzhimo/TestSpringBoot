package com.example.demo.mapper.seconddao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.example.demo.mapper.SelectBuilderTest;
import com.example.demo.model.Unit;
import com.example.demo.model.Unit1;

/**  
* @Title: UnitMapper.java  
* @Package com.example.demo.mapper.dao  
* @Description: 单位表
* @author wdm  
* @date 2018年6月23日  上午9:52:43
* @version V1.0  
*/
@CacheConfig(cacheNames="Cache")
public interface SecondUnitMapper {
	
	 List<Map<String, Object>> select();
	 
//	 List<Map<String, Object>> selectWhr(String p1,String p2);
	 List<Map<String, Object>> selectWhr(@Param("p1")String p1,@Param("p2")String p2);
	 
	 List<Map<String, Object>> selectWhrMap(Map<String, Object> map);
	 
	 List<Map<String, Object>> selectWhrList(List<String> list1);
	 
	 List<Map<String, Object>> selectWhrMapList(Map<String, Object> map);
	 
	 List<Map<String, Object>> selectWhrDyn(Unit unit);//动态sql
	 
	 List<Map<String, Object>> selectWhrDynTrim(Unit unit);//动态sql
	 
	 List<Map<String, Object>> selectWhrBind(Unit unit);//bind
	 
	 List<Map<String, Object>> selectWhrDynCho(@Param("p1")String dwmc,@Param("p2")String dwbh);//动态sql
	 
	 @Select("SELECT A.*,B.DWMC,B.DWBH FROM SYS_USER A LEFT JOIN SYS_UNIT B ON A.SSDW=B.GUID")
	 @Cacheable(key ="'allunit'")
	 List<Map<String, Object>> annselect();
	 
	 //----------------------------------------------------------------------------->
	 int addUnit(Unit unit);
	 
	 @Insert("INSERT INTO SYS_UNIT(GUID,DWMC,DWBH) VALUES (#{guid},#{dwmc},#{dwbh})")
	 int annAddUnit(Unit unit);
	 //----------------------------------------------------------------------------->
	 @SelectProvider(type = SelectBuilderTest.class, method = "SelectBuilder")
	 List<Map<String, Object>> SelectBuilderTest(String name);
	 
	@Select("SELECT * FROM SYS_UNIT ORDER BY DWBH")
	@Results({ @Result(property = "dw_gid", column = "guid"),
			   @Result(property = "dw_mc", column = "dwmc"),
			   @Result(property = "dw_bh", column = "dwbh")})
	List<Unit1> getAllUnit1();
	 
	 

}
