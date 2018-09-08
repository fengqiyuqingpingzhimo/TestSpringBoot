package com.example.demo.controller.api;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mq.activemq.Msg;
import com.example.demo.mq.activemq.Producer;
import com.example.demo.util.JsonResult;
import com.google.gson.Gson;

/**  
* @Title: Controller.java  
* @Package com.example.demo.controller.api  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午4:35:19
* @version V1.0  
*/
@Controller
@RequestMapping("api/mqtest")
public class ApiMqTestController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired JmsTemplate  jmsTemplate;
    @Autowired private Producer producer;
    
	@RequestMapping
    public ResponseEntity<JsonResult> loginPost(HttpServletRequest request) {
		logger.debug("消息队列测试接口!");
		System.err.println(new Gson().toJson(request.getParameterMap()));
		jmsTemplate.send("my-destination",new Msg());
		JsonResult r = new JsonResult();
		r.setResult("状态正常");
		r.setStatus("ok");
		return ResponseEntity.ok(r);
    }
	
	@RequestMapping("/sendMsg")
	@ResponseBody
	public void send(String msg) {
		msg=msg==null?"未接受到消息":msg;
		producer.send(1, msg);
	}

	@RequestMapping("/sendTopic")
	@ResponseBody
	public void sendTopic() {
		JsonResult r = new JsonResult();
		r.setResult("状态标识:sendTopic");
		r.setStatus("ok");
		producer.send(2, (Serializable) r);
	}

	@RequestMapping("/sendTopic2")
	@ResponseBody
	public void sendTopic2() {
		JsonResult r = new JsonResult();
		r.setResult("状态标识:sendTopic2");
		r.setStatus("ok");
		producer.send(3, (Serializable) r);
	}

}
