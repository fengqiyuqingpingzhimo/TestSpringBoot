package com.example.demo.mq.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

/**  
* @Title: Msg.java  
* @Package com.example.demo.mq.activemq  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午5:41:44
* @version V1.0  
*/
public class Msg implements MessageCreator {

	/* (non-Javadoc)
	 * @see org.springframework.jms.core.MessageCreator#createMessage(javax.jms.Session)
	 */
	@Override
	public Message createMessage(Session session) throws JMSException {
		return session.createTextMessage("测试消息");
	}

}
