package com.example.demo.mq.activemq;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.demo.mq.MqConstant;
import com.example.demo.util.JsonResult;

/**  
* @Title: Receiver.java  
* @Package com.example.demo.mq.activemq  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午5:51:32
* https://blog.csdn.net/qq_28423433/article/details/77948053
*/
@Component
public class Receiver {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@JmsListener(destination = MqConstant.Queue_Default,containerFactory="jmsListenerContainerQueue")
    public void  Queue_Default(ObjectMessage message){
		logger.debug("队列:Queue_Default,接受到消息:"+message);
    }
	@JmsListener(destination = MqConstant.Topic_Pull,containerFactory="jmsListenerContainerTopic")
    public void  Topic_Pull(ObjectMessage message) throws BeansException, JMSException{
		JsonResult r = new JsonResult();
		logger.info("r ：{}",message.getObject().toString());
		BeanUtils.copyProperties(r, message.getObject());
		logger.debug("队列:Topic_Pull,接受到消息:"+message);
		logger.debug("队列:Topic_Pull,实体类:"+r.toString());
    }
	@JmsListener(destination = MqConstant.Topic_Push,containerFactory="jmsListenerContainerTopic")
    public void  Topic_Push(ObjectMessage message){
		logger.debug("队列:Topic_Push,接受到消息:"+message);
    }
	@JmsListener(destination = MqConstant.Queue_Web,containerFactory="jmsListenerContainerQueue")
    public void  Queue_Web(String message){
		logger.debug("队列:Queue_Web,接受到消息:"+message);
    }
	
	@JmsListener(destination = "sample.queue")
    public void  receivedMessage2(String message){
		logger.debug("队列:sample.queue,接受到消息:"+message);
    }

}
