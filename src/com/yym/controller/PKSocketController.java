package com.yym.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
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
import com.yym.entity.PKWords;
import com.yym.entity.Player;
import com.yym.entity.Words;
import com.yym.service.PKSocketService;
import com.yym.service.impl.PKSocketServiceImpl;
import com.yym.util.EncoderClassVo;
@Controller
@ServerEndpoint(value="/getServer/{roomid}/{uid}",encoders= {EncoderClassVo.class})
public class PKSocketController {
	
	private PKSocketController webSocketServer;
	//静态变量，用来记录当前在线连接数，应该把它设计成线程安全的。
	private static int onlineCount=0;
	//concurrent包的线程安全set，用来存放每个客户端对应的MyWebSocket对象，若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中key可以为用户标识
	private static CopyOnWriteArraySet<WebSocketDemo> webSocketSet=new CopyOnWriteArraySet<WebSocketDemo>();
	//线程安全的Map
	private static ConcurrentHashMap<String,Session> webSocketMap =new ConcurrentHashMap<String,Session>();
	//每个用户所对应的房间
	private static ConcurrentHashMap<String,String> webSocketUser=new ConcurrentHashMap<String,String>();
	private static ConcurrentHashMap<String,Integer> webSocketNum=new ConcurrentHashMap<String,Integer>();
	private static PKSocketService pkSocketService;
	@Autowired
	public void setPkSocketService(PKSocketService pkSocketService) {
		PKSocketController.pkSocketService = pkSocketService;
	}

	@OnOpen
	public void onOpen(Session session,@PathParam("roomid")String roomid,@PathParam("uid")String uid) throws IOException, EncodeException {
		//将用户存进map
		webSocketMap.put(uid, session);
		webSocketUser.put(uid,roomid);
		if(webSocketNum.get(roomid)==null) {
			webSocketNum.put(roomid, 1);
		}else {
			if(webSocketNum.get(roomid)==2) {
				System.out.println("已满");
			}else {
				webSocketNum.put(roomid, webSocketNum.get(roomid)+1);
			}
		}
		System.out.println("Map:"+webSocketMap);
		System.out.println("User:"+webSocketUser);
		System.out.println("Num:"+webSocketNum);
	}

	/* 收到客户端消息时触发 */
	@OnMessage
	public void onMessage(Session session,String code) throws IOException, EncodeException {
		System.out.println(code);
		Map<String,String> map=session.getPathParameters();
		System.out.println("session.getPathParameters:"+map);
		int uid=Integer.parseInt(map.get("uid"));//获取用户的id
		String roomid=map.get("roomid");//获取用户的房间号
		if(code.equals("0")) {
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendMessage("true",webSocketMap.get(id));
				}
			}
		}else if(code.equals("1")) {
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendMessage("start",webSocketMap.get(id));
				}
			}
		}else if(code.equals("2")) {
			List<PKWords> list=this.getPKWords(uid);		
			System.out.println(list);
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendData(list,webSocketMap.get(id));
				}
			}
		}else {
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)&&Integer.parseInt(id)!=uid) {
					sendMessage(code,webSocketMap.get(id));
				}
			}
		}
	}
	private void sendData(List<PKWords> list, Session session) throws IOException, EncodeException {
		// TODO Auto-generated method stub
		
		if(session.isOpen()) {
			synchronized(session) {
				session.getBasicRemote().sendObject(list);
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
	public List<PKWords> getPKWords(int uid){
		Player p=pkSocketService.selPlayer(uid);
		List<PKWords> words=new ArrayList<PKWords>();
		String table_name="";
		if(p.getBank()=="高中题库") {
			table_name="highword";
		}else if(p.getBank()=="四级题库") {
			table_name="cet4word";
		}else if(p.getBank()=="六级题库") {
			table_name="cet6word";
		}else {
			table_name="postgraduateword";
		}	
		List<Words> list=pkSocketService.selPKWords(table_name);
		int index=0;
		for(Words w:list) {
			PKWords pk=new PKWords();
			pk.setId(index);
			pk.setWord(w.getWord());
			pk.setUs_pron(w.getUs_pron());
			pk.setUs_mp3(w.getUs_mp3());
			pk.setExplanation(w.getExplanation());
			Set<String> s=pkSocketService.selChoose(table_name);
			s.add(w.getExplanation());
			pk.setChoose(s);
			words.add(pk);
			index++;
		}
		return words;
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
