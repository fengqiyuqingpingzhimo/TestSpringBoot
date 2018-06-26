package com.example.demo.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mapper.dao.UnitMapper;
import com.example.demo.mapper.dao.UserMapper;
import com.example.demo.model.Unit;

/**  
* @Title: Test.java  
* @Package com.example.demo.mybatis  
* @Description: TODO
* @author wdm  
* @date 2018年6月21日  下午3:07:36
* @version V1.0  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
	
	@Autowired
	private UserMapper UserMapper;
	
	@Autowired private UnitMapper UnitMapper;
	
//	@org.junit.Test
//	public void testQuery() throws Exception {
////		List<Map<String, Object>> users = UserMapper.getUserDwList();
//		List<Map<String, Object>> users =UnitMapper.select();
//		System.out.println(users.toString());
//	}
//	
//	@org.junit.Test
//	public void testQuery1() throws Exception {
////		List<Map<String, Object>> users = UserMapper.getUserDwList();
//		List<Map<String, Object>> users =UnitMapper.annselect();
//		System.out.println(users.toString());
//	}
//	
	@org.junit.Test
	public void testQuery2() throws Exception {
//		List<Map<String, Object>> users = UserMapper.getUserDwList();
		
//		List<Map<String, Object>> users =UnitMapper.selectWhr("山","0002");
		
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("dwmc", "山");
//		map.put("dwbh", "0002");
//		List<Map<String, Object>> users =UnitMapper.selectWhrMap(map);
		
//		List<String> list=new ArrayList<>();
//		for(int i=1;i<3;i++) {
//			list.add("000"+i);
//		}
//		List<Map<String, Object>> users =UnitMapper.selectWhrList(list);
		
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("dwbh", "0001");
//		map.put("list", list);
//		List<Map<String, Object>> users =UnitMapper.selectWhrMapList(map);
		
//		System.out.println(users.toString());
		
//      ----------------------------------------------------------------------->
//		System.err.println(this.UnitMapper.addUnit(new Unit("天涯海阁","0005")));
//		System.out.println(UnitMapper.selectWhrDyn(new Unit("天涯海阁","0005")).toString());
//		System.out.println(UnitMapper.selectWhrDynCho(null,null).toString());
//		System.out.println(UnitMapper.selectWhrDynTrim(new Unit("1","天涯海阁","0005")).toString());
//		System.out.println(UnitMapper.selectWhrBind(new Unit("1","天涯海阁","0005")).toString());
		System.out.println(UnitMapper.SelectBuilderTest("门").toString());
	}
	


}
