package com.example.demo.mybatis;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.UnitService;

/**  
* @Title: Test2.java  
* @Package com.example.demo.mybatis  
* @Description: TODO
* @author wdm  
* @date 2018年6月27日  上午9:43:53
* @version V1.0  
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {
	
	@Autowired private UnitService unitservice;
	
	@org.junit.Test
	public void test() throws Exception {
		this.unitservice.TstlUpdate();
	}

}
