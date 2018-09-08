package com.example.demo.java.serializable;

import java.io.Serializable;

/**  
* @Title: Person.java  
* @Package com.example.demo.java.serializable  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午3:45:43
* @version V1.0  
*/
public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Man man;
	private String username;
    private transient int age;
	/**
	 * @return the man
	 */
	public Man getMan() {
		return man;
	}
	/**
	 * @param man the man to set
	 */
	public void setMan(Man man) {
		this.man = man;
	}
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param man
	 * @param username
	 * @param age
	 */
	public Person(Man man, String username, int age) {
		super();
		this.man = man;
		this.username = username;
		this.age = age;
	}
	/**
	 * 
	 */
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
