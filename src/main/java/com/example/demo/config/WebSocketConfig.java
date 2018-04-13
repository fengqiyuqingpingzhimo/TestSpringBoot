package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//import com.example.demo.websocket.WebSocketServer;

/**  
* @Title: WebSocketConfig.java  
* @Package com.example.demo.config  
* @Description: TODO
* @author wdm  
* @date 2018年4月1日  下午5:40:54
* @version V1.0  
*/
//@Configuration  
//@EnableWebSocket 
//public class WebSocketConfig implements WebSocketConfigurer {
//
//	/* (non-Javadoc)
//	 * @see org.springframework.web.socket.config.annotation.WebSocketConfigurer#registerWebSocketHandlers(org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry)
//	 */
//	@Override
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry arg0) {
//		// TODO Auto-generated method stub
//		arg0.addHandler(webSocketServer(), "/webSocketServer/*"); 
//	}
//	@Bean
//    public WebSocketHandler webSocketServer() {  
//        return new WebSocketServer();  
//    }  
//
//}
