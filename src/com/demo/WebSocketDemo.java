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
	//��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
	private static int onlineCount=0;
	//concurrent�����̰߳�ȫset���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����key����Ϊ�û���ʶ
	private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet=new CopyOnWriteArraySet<WebSocketDemo>();
	//�̰߳�ȫ��Map
	private static ConcurrentHashMap<String,Session> webSocketMap =new ConcurrentHashMap<String,Session>();
    /**
              * ���ӿ�ʼ���õķ���
     * @throws IOException 
    */
	@OnOpen
	public void onOpen(Session session,@PathParam("userId")String userId) throws IOException {
//		��ȡ��/websocket��ʼ���������ӣ����ڻ�ȡuserId��***=***�Ĳ���
	//	String uri=session.getRequestURI().toString();
		webSocketSet.add(this);
		webSocketMap.put(userId, session);
		addOnlineCount();//��������
		System.out.println(userId+"���뷿��");
		System.out.println("�������Ӽ���!��ǰ��������Ϊ"+getOnlineCount());
	}
	@OnClose
	public void onClose(Session session) {
		System.out.println("close");
		Map<String,String> map=session.getPathParameters();
		webSocketMap.remove(map.get("userId"));
		for(String user:webSocketMap.keySet()) {
			System.out.print(user);
		}
	    subOnlineCount(); //��������
	    System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());
	}
	/*
	 * �յ��ͻ�����Ϣ����õķ���
	 */
	@OnMessage
	public void onMessage(String message,Session session) throws IOException {
		System.out.println("���Կͻ��˵���Ϣ:"+message);
		Map<String,String> map=session.getPathParameters();
		String userId=map.get("userId");
		for(String user:webSocketMap.keySet()) {
			sendMessage("���Կ�ʼ��",webSocketMap.get(user));
		}
	}
	@OnError
	public void onError(Session session,Throwable error) {
		System.out.println("��������");
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
