package com.example.demo.util;

/**  
* @Title: AppUtil.java  
* @Package com.example.demo.util  
* @Description: 系统工具类
* @author wdm  
* @date 2018年6月27日  上午9:39:38
* @version V1.0  
*/
public class AppUtil {
	
	/**
	 * 取一个位数为Num的用数字、字母组成的随机字符串
	 * 2016年4月10日 13:40:14
	 * @param Num
	 * @return String
	 */
	public static String createGuid(int Num){
		String sjs[]={"1","2","3","4","5","6","7","8","9","0","a","b","c","d","e",
				"f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U",
				"V","W","X","Y","Z"};
		StringBuffer Str=new StringBuffer();
		for(int i=0;i<Num;i++){
			int a =(int)(Math.random()*62);
			Str.append(sjs[a]);
		}
		return Str.toString();
	}
	/**
	 * 默认32位ID
	 * @return
	 */
	public static String createGuid(){
		String sjs[]={"1","2","3","4","5","6","7","8","9","0","a","b","c","d","e",
				"f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U",
				"V","W","X","Y","Z"};
		StringBuffer Str=new StringBuffer();
		for(int i=0;i<32;i++){
			int a =(int)(Math.random()*62);
			Str.append(sjs[a]);
		}
		return Str.toString();
	}
	

}
