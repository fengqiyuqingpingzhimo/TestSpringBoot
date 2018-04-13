package com.example.demo.websocket;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**  
* @Title: WebSocketServer.java  
* @Package com.example.demo.websocket  
* @Description: TODO
* @author wdm  
* @date 2018年4月1日  下午5:42:08
* @version V1.0  
*/
//public class WebSocketServer extends TextWebSocketHandler {
//	
//	 private static final Map<WebSocketSession, String> connections = new ConcurrentHashMap<>();
//
//	    private static String getDatetime(Date date) {
//	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	        return format.format(date);
//	    }
//	    
//	    /**
//	     * 建立连接
//	     */
//	    @Override
//	    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//
//	        String uri = session.getUri().toString();
//	        String userName = uri.substring(uri.lastIndexOf("/") + 1);
//	        
//	        String nickname = URLDecoder.decode(userName, "utf-8");
//
//	        connections.put(session, nickname);
//	        String message = String.format("* %s %s", nickname, "加入聊天！");
//
//	        broadcast(new TextMessage(message));
//	    }
//
//	    /**
//	     * 断开连接
//	     */
//	    @Override
//	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//	        String nickname = connections.remove(session);
//	        String message = String.format("* %s %s", nickname, "退出聊天！");
//	        
//	        broadcast(new TextMessage(message));
//	    }
//
//	    /**
//	     * 处理消息
//	     */
//	    @Override
//	    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//	        String msg = "【" + connections.get(session) + "】" + getDatetime(new Date()) + " : " + message.getPayload();
//	        
//	        broadcast(new TextMessage(msg));
//	    }
//
//	    private static void broadcast(TextMessage msg) {
//	        // 广播形式发送消息
//	        for (WebSocketSession session : connections.keySet()) {
//	            try {
//	                synchronized (session) {
//	                    session.sendMessage(msg);
//	                }
//	            } catch (Exception e) {
//	                connections.remove(session);
//	                try {
//	                    session.close();
//	                } catch (Exception e2) {
//	                    e2.printStackTrace();
//	                }
//	                String message = String.format("* %s %s", connections.get(session), "断开连接");
//	                broadcast(new TextMessage(message));
//	            }
//	        }
//	    }
//
//}
