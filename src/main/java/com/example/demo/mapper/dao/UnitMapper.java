package com.example.demo.mapper.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

/**  
* @Title: UnitMapper.java  
* @Package com.example.demo.mapper.dao  
* @Description: 单位表
* @author wdm  
* @date 2018年6月23日  上午9:52:43
* @version V1.0  
*/
public interface UnitMapper {
	
	 List<Map<String, Object>> select();
	 
	 @Select("SELECT A.*,B.DWMC,B.DWBH FROM SYS_USER A LEFT JOIN SYS_UNIT B ON A.SSDW=B.GUID")
	 List<Map<String, Object>> annselect();

}
