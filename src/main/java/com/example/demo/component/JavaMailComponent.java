//package com.example.demo.component;
//
//import java.io.UnsupportedEncodingException;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.mail.MailProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
//
///**  
//* @Title: JavaMailComponent.java  
//* @Package com.example.demo.component  
//* @Description: TODO
//* @author wdm  
//* @date 2018年4月3日  上午10:23:38
//* @version V1.0  
//*/
//@Component
//@EnableConfigurationProperties(MailProperties.class)
//public class JavaMailComponent {
//	private static final String template = "mail.ftl";
//    @Autowired
//    private FreeMarkerConfigurer freeMarkerConfigurer;
//    
//    @Autowired
//    private JavaMailSender javaMailSender;
//    @Autowired
//    private MailProperties mailProperties;
//    public void sendMail(String email) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("email", email);
//        try {
//            // 获取内容
//            String text = this.getTextByTemplate(template, map);
//            // 发送
//            this.send(email, text);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    private String getTextByTemplate(String template, Map<String, Object> model) throws Exception {
//        return FreeMarkerTemplateUtils
//                .processTemplateIntoString(this.freeMarkerConfigurer.getConfiguration().getTemplate(template), model);
//    }
//    private String send(String email, String text) throws MessagingException, UnsupportedEncodingException {
//        MimeMessage message = this.javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//        InternetAddress from = new InternetAddress();
//        from.setAddress(this.mailProperties.getUsername());
//        from.setPersonal("月光中的污点", "UTF-8");
//        helper.setFrom(from);
//        helper.setTo(email);
//        helper.setSubject("SpringBoot 发送的第一封邮件");
//        helper.setText(text, true);
//        this.javaMailSender.send(message);
//        return text;
//    }
//
//}
