package com.example.demo.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**  
* @Title: Runner.java  
* @Package com.example.demo.init  
* @Description: 初始化操作相关
* @author wdm  
* @date 2018年6月8日  上午9:00:21
* @version V1.0  
*/
@Component
public class Runner implements CommandLineRunner {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
         this.logger.debug(".....init.....");
	}

}
