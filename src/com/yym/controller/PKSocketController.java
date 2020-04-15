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
import org.springframework.stereotype.Controller;

import com.demo.WebSocketDemo;
import com.yym.service.PKSocketService;
import com.yym.service.impl.PKSocketServiceImpl;
@Controller
@ServerEndpoint("/getServer/{roomid}/{uid}")
public class PKSocketController {
	
	private PKSocketController webSocketServer;
	//��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
	private static int onlineCount=0;
	//concurrent�����̰߳�ȫset���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����key����Ϊ�û���ʶ
	private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet=new CopyOnWriteArraySet<WebSocketDemo>();
	//�̰߳�ȫ��Map
	private static ConcurrentHashMap<String,Session> webSocketMap =new ConcurrentHashMap<String,Session>();
	//ÿ���û�����Ӧ�ķ���
	private static ConcurrentHashMap<String,String> webSocketUser=new ConcurrentHashMap<String,String>();
	private static ConcurrentHashMap<String,Integer> webSocketNum=new ConcurrentHashMap<String,Integer>();
	private static PKSocketService pkSocketService;
	@Autowired
	public void setPkSocketService(PKSocketService pkSocketService) {
		PKSocketController.pkSocketService = pkSocketService;
	}

	@OnOpen
	public void onOpen(Session session,@PathParam("roomid")String roomid,@PathParam("uid")String uid) throws IOException {
		//���û����map
		System.out.println(pkSocketService);
		webSocketMap.put(uid, session);
		webSocketUser.put(uid,roomid);
		if(webSocketNum.get(roomid)==null) {
			webSocketNum.put(roomid, 1);
		}else {
			if(webSocketNum.get(roomid)==2) {
				System.out.println("����");
			}else {
				webSocketNum.put(roomid, webSocketNum.get(roomid)+1);
			}
		}
		System.out.println("Map:"+webSocketMap);
		System.out.println("User:"+webSocketUser);
		System.out.println("Num:"+webSocketNum);
	}

	/* �յ��ͻ�����Ϣʱ���� */
	@OnMessage
	public void onMessage(Session session,String roomid) throws IOException {
		System.out.println("roomid:"+roomid);
		System.out.println(roomid.substring(1, roomid.length()));
		if(roomid.charAt(0)!='0') {
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendMessage("true",webSocketMap.get(id));
				}
			}
		}else {
			roomid=roomid.substring(1, roomid.length());
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendMessage("start",webSocketMap.get(id));
				}
			}
		}

	}
	public void sendMessage(String message,Session session) throws IOException {
		System.out.println(session);
		if(session.isOpen()) {
			synchronized(session) {
				session.getBasicRemote().sendText(message);
			}	
		}
	}
	@OnError
	public void onError(Throwable error,Session session) {
		System.out.println("��������");
		error.printStackTrace();
	}
	@OnClose
	public void onClose(Session session) {
		Map<String,String> map=session.getPathParameters();
		webSocketMap.remove(map.get("uid"));
		webSocketUser.remove(map.get("uid"));
		webSocketNum.remove(map.get("roomid"));
		System.out.println(webSocketMap);
		System.out.println(webSocketUser);
		System.out.println(webSocketNum);
	}
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}
	public static synchronized void addOnlineCount() {
		PKSocketController.onlineCount++;
	}
	public static synchronized void subOnlineCount() {
		PKSocketController.onlineCount--;
	}
	
}
