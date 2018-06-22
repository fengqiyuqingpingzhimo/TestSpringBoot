package com.example.demo.controller.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* @Title: VueController.java  
* @Package com.example.demo.controller.admin  
* @Description: TODO
* @author wdm  
* @date 2018年6月20日  下午2:26:58
* @version V1.0  
*/
@Controller
@RequestMapping("vue")
public class VueController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("")
    public String enter() {
		logger.debug("vueController");
        return "test_vue/test";
    }
	

}
