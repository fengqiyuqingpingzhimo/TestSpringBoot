package com.example.demo.java.serializable;

import java.io.Serializable;

/**  
* @Title: Man.java  
* @Package com.example.demo.java.serializable  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午3:44:22
* @version V1.0  
*/
public class Man implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username;
    private String password;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param username
	 * @param password
	 */
	public Man(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	/**
	 * 
	 */
	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
