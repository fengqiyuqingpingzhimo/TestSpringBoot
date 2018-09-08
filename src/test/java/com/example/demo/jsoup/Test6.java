package com.example.demo.jsoup;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

/**  
* @Title: Test.java  
* @Package com.example.demo  
* @Description: 抓取句子迷网站信息
* @author wdm  
* @date 2018年3月20日  下午9:16:37
* @version V1.0  
*/
public class Test6 {
	private static final Logger logger = LoggerFactory.getLogger(Test6.class);
	public static void main(String[] args) {
		
//		 String url="http://192.168.4.1/yggl/data/login_data.aspx";
		String url="http://192.168.10.171/api/gsontest";
		 logger.info("开始执行!");
		 try {
//				 Connection conn=Jsoup.connect(url).timeout(5000); 
				 Connection conn=Jsoup.connect(url);
				 conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
				 conn.header("Accept-Encoding", "gzip, deflate, sdch");  
				 conn.header("Accept-Language", "zh-CN,zh;q=0.9");  
				 conn.header("Cache-Control", "max-age=0");  
				 conn.header("Connection", "keep-alive");
				 conn.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8"); 
//				 conn.header("Cookie", "txt_user=000666; ASP.NET_SessionId=ckzgwpiowmpjuevryb2cv445; CheckCode=9120");  
				 conn.header("Host", "192.168.4.1"); 
				 conn.header("DNT", "1");  
				 conn.header("Origin", "http://192.168.4.1");  
				 conn.header("Referer", "http://192.168.4.1/yggl/");  
				 conn.header("If-Modified-Since", new Date().toString());  
				 conn.header("If-None-Match", "\"468772839997c36742c0ecd9d8f775c2\"");  
				 conn.header("Upgrade-Insecure-Requests", "1");  
				 conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");  
				 Map<String, String> map=new HashMap<String, String>();
				 map.put("mm", "wdm123!");
				 conn.data("menu", "user-login");
				 conn.data("username", "王得民");
				 conn.data("password", new Gson().toJson(map));
				 try {
			        Response resp=conn.method(Method.POST).execute(); 
			        logger.info(resp.body());
//			        //获取cookie
//			        String cookieValue = resp.cookie("txt_user");
//			        System.out.println(cookieValue);
//					 Document doc=conn.post();
//					 logger.info(doc.ownText());
				 }catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
					 logger.error("执行失败,异常解析:{}",e.getMessage()); 
				}
//			 }
		} catch (Exception e) {
			logger.error("执行失败!"); 
			e.printStackTrace();
		}
		logger.info("执行完毕!"); 
	}

}
