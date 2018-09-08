package com.example.demo.mq.activemq;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.mq.MqConstant;

/**  
* @Title: Producer.java  
* @Package com.example.demo.mq.activemq  
* @Description: 消息生产者
* @author wdm  
* @date 2018年9月7日  下午6:31:49
*/
@Component
public class Producer {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	private Destination destination = null;
	
	public void send(int i, final Serializable order) {
		// 规定好topic 或者queue 输入不同的i标识生产不同的 destination
		switch (i) {
			case 1:
				destination = new ActiveMQQueue(MqConstant.Queue_Web);break;
			case 2:
				destination = new ActiveMQTopic(MqConstant.Topic_Pull);break;
			case 3:
				destination = new ActiveMQTopic(MqConstant.Topic_Push);break;
		    default:
		    	destination = new ActiveMQQueue(MqConstant.Queue_Default);break;
		}
		Map<String, Object> headers = new HashMap<String, Object>();
		// 可在消息接收时设置一些属性 这里随便写的没啥用
		headers.put("type", 1);
		// order对象是普通pojo对象 需要实现序列化接口
		this.jmsMessagingTemplate.convertAndSend(destination, order);

	}
	

}
