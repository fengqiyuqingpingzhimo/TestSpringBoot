package com.example.demo.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**  
* @Title: OrderRunner1.java  
* @Package com.example.demo.init  
* @Description: TODO
* @author wdm  
* @date 2018年6月8日  上午9:13:11
* @version V1.0  
*/
@Component
@Order(1)
public class OrderRunner1 implements CommandLineRunner {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		this.logger.debug(">>......init..order1.......>");

	}

}
