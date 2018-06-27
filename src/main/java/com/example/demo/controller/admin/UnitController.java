package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Unit;
import com.example.demo.service.UnitService;
import com.example.demo.util.JsonResult;

/**  
* @Title: UnitController.java  
* @Package com.example.demo.controller.admin  
* @Description: TODO
* @author wdm  
* @date 2018年6月27日  下午2:32:11
* @version V1.0  
*/
@Controller
@RequestMapping("unit")
public class UnitController {
	
	@Autowired private UnitService service;
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> add (Unit unit){
		JsonResult r = new JsonResult();
		try {
			int orderId = service.addUnit(unit);
			if (orderId < 0) {
				r.setResult(orderId);
				r.setStatus("fail");
			} else {
				r.setResult(orderId);
				r.setStatus("ok");
			}
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	

}
