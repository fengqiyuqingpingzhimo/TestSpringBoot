package com.example.demo.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JsonResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**  
* @Title: UserController.java  
* @Package com.example.demo.controller  
* @Description: TODO
* @author wdm  
* @date 2018年4月13日  下午2:55:17
* @version V1.0  
*/
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserById (@PathVariable(value = "id") String id){
		JsonResult r = new JsonResult();
		try {
			User user = userService.selectByPrimaryKey(id);
			r.setResult(user);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	/**
	 * 根据ID查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "annuser/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getAnnUserById (@PathVariable(value = "id") String id){
		JsonResult r = new JsonResult();
		try {
			User user = userService.annSelectByPrimaryKey(id);
			r.setResult(user);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	/**
	 * 查询用户列表
	 * @return
	 */
	@RequestMapping(value = "users", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserList (@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
		PageHelper.startPage(pageNum,5);
		JsonResult r = new JsonResult();
		try {
			List<User> users = userService.getUserList();
			PageInfo<User> pageInfo = new PageInfo<User>(users);
			r.setResult(pageInfo);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	@RequestMapping(value = "users1", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserList1 (@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
		PageHelper.startPage(pageNum,5);
		JsonResult r = new JsonResult();
		try {
			List<User> users = userService.getUserList1();
			PageInfo<User> pageInfo = new PageInfo<User>(users);
			r.setResult(pageInfo);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	/**
	 * 查询有单位的用户列表列表
	 * @return
	 */
	@RequestMapping(value = "usersdw", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> getUserDwList (@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum){
		PageHelper.startPage(pageNum,5);
		JsonResult r = new JsonResult();
		try {
			List<Map<String, Object>> users = userService.getUserDwList();
			PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(users);
			r.setResult(pageInfo);
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> add (User user){
		JsonResult r = new JsonResult();
		try {
			int orderId = userService.insertSelective(user);
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
	/**
	* @Description: 删除用户
	* @author wdm  
	* @date 2018年4月14日  上午10:53:45
	 */
	@RequestMapping(value = "deluser/{id}", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> deluser (@PathVariable(value = "id")String gid){
		JsonResult r = new JsonResult();
		try {
		   userService.delete(gid);
			r.setResult("删除成功!");
			r.setStatus("ok");
		} catch (Exception e) {
			r.setResult(e.getClass().getName() + ":" + e.getMessage());
			r.setStatus("error");
			e.printStackTrace();
		}
		return ResponseEntity.ok(r);
	}
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "adduser", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> annInsert (User user){
		JsonResult r = new JsonResult();
		System.err.println(user.toString());
		try {
			int orderId = userService.annInsert(user);
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
	/**
	 * 修改用户信息
	 * @Description: TODO
	 * @author wdm  
	 * @date 2018年6月25日  上午9:17:24
	 * http://localhost/upduser?id=6F230F564092C365E050A8C0D90A1A70&loginname=修改
	 */
	@RequestMapping(value = "upduser", method = RequestMethod.GET)
	public ResponseEntity<JsonResult> upduser (User user){
		JsonResult r = new JsonResult();
		System.err.println(user.toString());
		try {
			int orderId = userService.updateByPrimaryKeySelective(user);
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
