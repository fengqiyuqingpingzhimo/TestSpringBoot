package com.example.demo.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

/**  
* @Title: DateConverterConfig.java  
* @Package com.example.demo.config  
* @Description: 日期格式处理相关
* @author wdm  
* @date 2018年6月21日  下午4:36:06
* @version V1.0  
*/
@Configuration
public class DateConverterConfig {
	
	 private static final List<String> formarts = new ArrayList<>(4);
	    static{
	        formarts.add("yyyy-MM");
	        formarts.add("yyyy-MM-dd");
	        formarts.add("yyyy-MM-dd hh:mm");
	        formarts.add("yyyy-MM-dd hh:mm:ss");
	    }
	    
		@Bean
	    public Converter<String, Date> addNewConvert() {
	        return new Converter<String, Date>() {
	            @Override
	            public Date convert(String source) {
//	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                Date date = null;
	                try {
//	                    date = sdf.parse((String) source);
	                	if(source.matches("^\\d{4}-\\d{1,2}$")){
	        	            return parseDate(source, formarts.get(0));
	        	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
	        	            return parseDate(source, formarts.get(1));
	        	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
	        	            return parseDate(source, formarts.get(2));
	        	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
	        	            return parseDate(source, formarts.get(3));
	        	        }else {
	        	            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
	        	        }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                return date;
	            }
	        };
	    }
//	    public Date convert(String source) {
//	        String value = source.trim();
//	        if ("".equals(value)) {
//	            return null;
//	        }
//	        if(source.matches("^\\d{4}-\\d{1,2}$")){
//	            return parseDate(source, formarts.get(0));
//	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
//	            return parseDate(source, formarts.get(1));
//	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$")){
//	            return parseDate(source, formarts.get(2));
//	        }else if(source.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$")){
//	            return parseDate(source, formarts.get(3));
//	        }else {
//	            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
//	        }
//	    }

	    /**
	     * 格式化日期
	     * @param dateStr String 字符型日期
	     * @param format String 格式
	     * @return Date 日期
	     */
	    public  Date parseDate(String dateStr, String format) {
	        Date date=null;
	        try {
	            DateFormat dateFormat = new SimpleDateFormat(format);
	            date = dateFormat.parse(dateStr);
	        } catch (Exception e) {

	        }
	        return date;
	    }

}
