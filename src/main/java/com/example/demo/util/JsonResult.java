package com.example.demo.util;

/**  
* @Title: JsonResult.java  
* @Package com.example.demo.util  
* @Description: springboot controller 通用json返回类
* @author wdm  
* @date 2018年4月13日  下午2:58:27
* @version V1.0  
* 关于status变量为String 而不是boolean情况说明: 字符串可以表达更多的情况 如ok error fail等,boolean只能适应更少的情况
*/
public class JsonResult {
	
	private String status = null;

	private Object result = null;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * 
	 */
	public JsonResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param status
	 * @param result
	 */
	public JsonResult(String status, Object result) {
		super();
		this.status = status;
		this.result = result;
	}
	
	
	
	

}
