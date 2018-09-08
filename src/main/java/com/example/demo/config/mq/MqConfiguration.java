package com.example.demo.config.mq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**  
* @Title: MqConfiguration.java  
* @Package com.example.demo.config  
* @Description: 消息队列注册类
* @author wdm  
* @date 2018年9月7日  下午6:03:34
*/
@Configuration
public class MqConfiguration {
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}

}
