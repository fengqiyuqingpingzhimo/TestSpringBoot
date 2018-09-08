package com.example.demo.java.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**  
* @Title: Test.java  
* @Package com.example.demo.java.serializable  
* @Description: TODO
* @author wdm  
* @date 2018年9月7日  下午3:47:16
* @version V1.0  
*/
public class Test {
	
	// Serializable：把对象序列化
	public static void writeSerializableObject() {
	    try {
	        Man man = new Man("wdm", "123456");
	        Person person = new Person(man, "wdm", 18);
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:\\output.txt"));
	        objectOutputStream.writeObject("string");
	        objectOutputStream.writeObject(person);
	        objectOutputStream.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	// Serializable：反序列化对象
	public static void readSerializableObject() {
	    try {
	        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:\\output.txt"));
	        String string = (String) objectInputStream.readObject();
	        Person person = (Person) objectInputStream.readObject();
	        objectInputStream.close();
	        System.out.println(string + ", age: " + person.getAge() + ", man username: " + person.getMan().getUsername());
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**  
	* @Description: TODO
	* @author wdm  
	* @date 2018年9月7日  下午3:47:16
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test.writeSerializableObject();
		Test.readSerializableObject();

	}

}
