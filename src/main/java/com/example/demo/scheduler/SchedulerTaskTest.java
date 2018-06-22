package com.example.demo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**  
* @Title: SchedulerTaskTest.java  
* @Package com.example.demo.timer  
* @Description: TODO
* @author wdm  
* @date 2018年6月5日  上午11:13:08
* @version V1.0  
*/
@Component
public class SchedulerTaskTest {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
//	  @Scheduled(fixedRate = 6000)
//	    public void reportCurrentTime() {
//	    	try {
//				Thread.sleep(8000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	    	logger.debug("task22222现在时间:{}", new SimpleDateFormat("HH:mm:ss").format(new Date()));
//	    }


}
