package com.example.demo.controller;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	 @RequestMapping(value="/hello", method=RequestMethod.GET)  
	 public String HelloController() {  
	        return "Hello World!";  
	 }  
	 @RequestMapping(value="/hello2", method=RequestMethod.GET)  
	 public String Hello2Controller() {  
		 String url="http://www.271edu.cn/official/gi-18429";
		 logger.info("抓取网页数据!");
		 try {
//			Connection conn=Jsoup.connect(url).timeout(5000); 
//			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
//			conn.header("Accept-Encoding", "gzip, deflate, sdch");  
//			conn.header("Accept-Language", "zh-CN,zh;q=0.8");  
//            conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");  
            Document doc=Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").get();  
			Elements ele=doc.getElementsByClass("bdiv");
			logger.info(ele.text());
		} catch (IOException e) {
//			logger.error("抓取网页信息失败!"); 
			e.printStackTrace();
		}
		logger.info("抓取网页执行完毕!"); 
	    return "Hello2 World!";  
	 }  
	 
	 

}
