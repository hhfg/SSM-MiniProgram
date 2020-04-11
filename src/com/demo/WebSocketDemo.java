package com.demo;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@ServerEndpoint(value="/newwebsocket/{roomid}/{userId}")
public class WebSocketDemo {
	@Resource
	private WebSocketDemo webSocketDemo;
	//静态变量，用来记录当前在线连接数，应该把它设计成线程安全的。
	private static int onlineCount=0;
	//concurrent包的线程安全set，用来存放每个客户端对应的MyWebSocket对象，若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中key可以为用户标识
	private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet=new CopyOnWriteArraySet<WebSocketDemo>();
	//线程安全的Map
	private static ConcurrentHashMap<String,Session> webSocketMap =new ConcurrentHashMap<String,Session>();
    /**
              * 连接开始调用的方法
     * @throws IOException 
    */
	@OnOpen
	public void onOpen(Session session,@PathParam("userId")String userId) throws IOException {
//		获取从/websocket开始的整条链接，用于获取userId？***=***的参数
	//	String uri=session.getRequestURI().toString();
		webSocketSet.add(this);
		webSocketMap.put(userId, session);
		addOnlineCount();//在线数加
		System.out.println(userId+"进入房间");
		System.out.println("有新连接加入!当前在线人数为"+getOnlineCount());
	}
	@OnClose
	public void onClose(Session session) {
		System.out.println("close");
		Map<String,String> map=session.getPathParameters();
		webSocketMap.remove(map.get("userId"));
		for(String user:webSocketMap.keySet()) {
			System.out.print(user);
		}
	    subOnlineCount(); //在线数减
	    System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
	}
	/*
	 * 收到客户端消息后调用的方法
	 */
	@OnMessage
	public void onMessage(String message,Session session) throws IOException {
		System.out.println("来自客户端的消息:"+message);
		Map<String,String> map=session.getPathParameters();
		String userId=map.get("userId");
		for(String user:webSocketMap.keySet()) {
			sendMessage("可以开始了",webSocketMap.get(user));
		}
	}
	@OnError
	public void onError(Session session,Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}
	public void sendMessage(String message,Session session) {
		if(session.isOpen()) {
			session.getAsyncRemote().sendText(message);
		}
	}
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	public static synchronized void addOnlineCount() {
		WebSocketDemo.onlineCount++;
	}
	public static synchronized void subOnlineCount() {
		WebSocketDemo.onlineCount--;
	}
}
