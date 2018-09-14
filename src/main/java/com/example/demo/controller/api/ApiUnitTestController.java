package com.example.demo.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UnitService;
import com.example.demo.util.JsonResult;
import com.google.gson.Gson;

/**  
* @Description: TODO
* @author wdm  
* @date 2018年9月13日  上午10:10:36
*/
@RestController
@RequestMapping("/api/unittest")
public class ApiUnitTestController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired private UnitService service;
	@RequestMapping
    public ResponseEntity<JsonResult> getAllUnit1() {
		logger.debug("测试接口!");
		JsonResult r = new JsonResult();
		System.err.println(new Gson().toJson(this.service.getAllUnits1()));
		r.setResult(this.service.getAllUnit1());
		r.setStatus("ok");
		return ResponseEntity.ok(r);
    }
	
	@RequestMapping("dotest")
    public ResponseEntity<JsonResult> dotest() {
		logger.debug("测试接口!");
		JsonResult r = new JsonResult();
		this.service.doTest();
		r.setResult("123");
		r.setStatus("ok");
		return ResponseEntity.ok(r);
    }

}
