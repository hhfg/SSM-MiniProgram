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
	//每个用户所对应的房间
	private static ConcurrentHashMap<String,String> webSocketUser=new ConcurrentHashMap<String,String>();
	//private static CopyOnWriteArraySet<String> webSocketRoom=new CopyOnWriteArraySet<String>();
	@OnOpen
	public void onOpen(Session session,@PathParam("roomid")String roomid,@PathParam("uid")String uid) {
		//将用户存进map
		webSocketMap.put(uid, session);
		webSocketUser.put(uid,roomid);
		System.out.println(webSocketUser);
	}

	/* 收到客户端消息时触发 */
	@OnMessage
	public void onMessage(Session session,String roomid) {
		System.out.println("onmessage");
		Map<String,String> map=session.getPathParameters();
		String userId=map.get("uid");
		System.out.println(webSocketMap);
		System.out.println(webSocketUser.keySet());
		for(String uid:webSocketUser.keySet()) {
			System.out.println(uid);
			if(webSocketUser.get(uid).equals(roomid)) {
				sendMessage("true",webSocketMap.get(uid));
			}
		}
//		for(String uid:webSocketMap.keySet()) {
//			System.out.println(webSocketMap.get(uid));
//			sendMessage(uid+"已满",webSocketMap.get(uid));
//		}
	}
	public void sendMessage(String message,Session session) {
		System.out.println(session+"-"+session.isOpen());
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
		webSocketMap.remove(map.get("uid"));
		System.out.println(webSocketMap);
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
