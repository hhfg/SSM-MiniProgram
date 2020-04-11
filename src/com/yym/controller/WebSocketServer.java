package com.yym.controller;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.WebSocketDemo;

@ServerEndpoint("/getServer/{roomid}/{uid}")
public class WebSocketServer {
	@Autowired
	private WebSocketServer webSocketServer;
	//静态变量，用来记录当前在线连接数，应该把它设计成线程安全的。
	private static int onlineCount=0;
	//concurrent包的线程安全set，用来存放每个客户端对应的MyWebSocket对象，若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中key可以为用户标识
	private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet=new CopyOnWriteArraySet<WebSocketDemo>();
	//线程安全的Map
	private static ConcurrentHashMap<String,Session> webSocketMap =new ConcurrentHashMap<String,Session>();
	//用来存放每个房间的人数
	private static ConcurrentHashMap<String,Integer> webSocketNum=new ConcurrentHashMap<String,Integer>();
	
	@OnOpen
	public void onOpen(Session session,@PathParam("roomid")String roomid,@PathParam("uid")String uid) {
		//将房间号存进map中
		webSocketMap.put(roomid, session);
		for(String id:webSocketMap.keySet()) {
			if(roomid.equals(id)) {	
				System.out.println(webSocketNum.get("roomid"));
				if(webSocketNum.get(roomid)!=null) {
					webSocketNum.put(roomid, webSocketNum.get(roomid)+1);
				}
				else if(webSocketNum.get(roomid)==null){
					webSocketNum.put(roomid,1);
				}
				
			}
		}
		System.out.println(webSocketMap);
		System.out.println(webSocketNum);
		//this.onMessage(session,"true");
	}

	/* 收到客户端消息时触发 */
	@OnMessage
	public String onMessage(Session session,String message) {
		Map<String,String> map=session.getPathParameters();
		return message;	
	}
	public void sendMessage(String message,Session session) {
		if(session.isOpen()) {
			session.getAsyncRemote().sendText(message);
		}
	}
	@OnError
	public void onError(Throwable error,Session session) {
		System.out.println("发生错误");
		error.printStackTrace();
	}
	@OnClose
	public void onClose(Session session) {
		Map<String,String> map=session.getPathParameters();
		webSocketMap.remove(map.get("roomid"));
		webSocketNum.remove(map.get("roomid"));
		System.out.println(webSocketMap);
		System.out.println(webSocketNum);
	}
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	public static synchronized void addOnlineCount() {
		WebSocketServer.onlineCount++;
	}
	public static synchronized void subOnlineCount() {
		WebSocketServer.onlineCount--;
	}
	
}
