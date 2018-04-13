package com.example.demo.jsoup;

import java.io.IOException;
import java.util.Date;

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
public class Test2 {
	private static final Logger logger = LoggerFactory.getLogger(Test2.class);
	public static void main(String[] args) {
		
//		 String url="http://192.168.4.1/yggl/yggl/yg_ygList.aspx";
//		 String url="http://localhost/Zxxjw/webedu";
		 logger.info("开始执行!");
		 try {
			 for(int i=1167490;i<1167491;i++) {
				 String url="http://www.juzimi.com/ju/"+i;
				 Connection conn=Jsoup.connect(url).timeout(5000); 
				 conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
				 conn.header("Accept-Encoding", "gzip, deflate, sdch");  
				 conn.header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6");  
				 conn.header("Cache-Control", "max-age=0");  
				 conn.header("Connection", "keep-alive");  
				 conn.header("Cookie", "UM_distinctid=162282b1d19c5-04caf133afc5be-6b1b1279-1fa400-162282b1d1b6e; CNZZDATA1256504232=606182254-1521087090-%7C1521087090; SESSc60faee9ca2381b86f19bef9617d499b=e8ssnmn3ju527fdo3bsgoehs81; __cfduid=d71b54b98753e2a78275f07dbf8aa07961522303724; xqrclbr=81369; visited=1; homere=1; bdshare_firstime=1522303718060; has_js=1; Hm_lvt_0684e5255bde597704c827d5819167ba=1522303717; Hm_lpvt_0684e5255bde597704c827d5819167ba=1522303722; Hm_cv_0684e5255bde597704c827d5819167ba=1*login*PC-0!1*version*PC; _ga=GA1.2.88695297.1522303718; xqrcli=MTUyMjMwMzcyMiwxOTIwKjEwODAsV2luMzIsTmV0c2NhcGUsODEzNjk%3D");  
				 conn.header("Host", "www.juzimi.com");  
				 conn.header("If-Modified-Since", new Date().toString());  
				 conn.header("If-None-Match", "\"468772839997c36742c0ecd9d8f775c2\"");  
				 conn.header("Upgrade-Insecure-Requests", "1");  
				 conn.header("X-Forwarded-For", "10.0.0.1");  
				 conn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");  
//            Document doc=Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").get();  
				 try {
					 Document doc=conn.get();
					 Elements ele=doc.getElementsByClass("with-tabs");
					 logger.info(ele.text());
					 logger.info(doc.getElementsByClass("senconwriart").text());
				 }catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
					 logger.error("执行失败,异常解析:{}",e.getMessage()); 
				}
				 Thread r=new Thread();
				 r.sleep(5000);
			 }
		} catch (Exception e) {
			logger.error("执行失败!"); 
			e.printStackTrace();
		}
		logger.info("执行完毕!"); 
	}

}
