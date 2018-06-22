package com.example.demo.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
* @Title: Test.java  
* @Package com.example.demo  
* @Description: TODO
* @author wdm  
* @date 2018年3月20日  下午9:16:37
* @version V1.0  
*/
public class Test {
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		
//		 String url="http://192.168.4.1/yggl/yggl/yg_ygList.aspx";
		 String url="http://xkkm.sdzk.cn/zy-manager-web/gxxx/searchInfor?xxdm=10002&xxmc=%E4%B8%AD%E5%9B%BD%E4%BA%BA%E6%B0%91%E5%A4%A7%E5%AD%A6";
		 logger.info("抓取网页数据!");
		 try {
//			Connection conn=Jsoup.connect(url).timeout(5000); 
//			conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");  
//			conn.header("Accept-Encoding", "gzip, deflate, sdch");  
//			conn.header("Accept-Language", "zh-CN,zh;q=0.8");  
//            conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");  
            Document doc=Jsoup.connect(url).header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:33.0) Gecko/20100101 Firefox/33.0").get();  
			Elements ele=doc.getElementsByClass("table");
			logger.info(ele.html());
			logger.info(ele.text());
		} catch (IOException e) {
			logger.error("抓取网页信息失败!"); 
			e.printStackTrace();
		}
		logger.info("抓取网页执行完毕!"); 
	}

}
