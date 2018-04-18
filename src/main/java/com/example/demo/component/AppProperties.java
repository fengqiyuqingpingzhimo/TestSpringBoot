package com.example.demo.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**  
* @Title: AppProperties.java  
* @Package com.example.demo.component  
* @Description: 读取配置文件中 的某些值
* @author wdm  
* @date 2018年4月18日  下午4:13:37
* @version V1.0  
*/
@Component
public class AppProperties {
	@Value("${com.app.author}")
	private String author;
	@Value("${com.app.time}")
	private String time;
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	

}
