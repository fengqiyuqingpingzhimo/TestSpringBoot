package com.example.demo.mq.activemq;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**  
* @Title: JmsTest.java  
* @Package com.example.demo.mq.activemq  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午6:00:41
* @version V1.0  
*/
@Component
public class JmsTest {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired private Queue queue;
	
//	@Scheduled(cron="*/10 * * * * ?")
//    private void send(){
//		String data=new SimpleDateFormat("HH:mm:ss").format(new Date());
//    	logger.debug("现在时间:{}",data);
//    	this.jmsMessagingTemplate.convertAndSend(this.queue, data);
//    }

}
