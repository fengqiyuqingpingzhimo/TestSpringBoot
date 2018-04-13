package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**  
* @Title: TestListener.java  
* @Package com.example.demo.listener  
* @Description: TODO
* @author wdm  
* @date 2018年3月21日  上午5:23:48
* @version V1.0  
*/
public class TestListener implements ServletContextListener {

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("监听器初始化...");

	}

}
