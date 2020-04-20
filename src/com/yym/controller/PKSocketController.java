package com.yym.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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
import com.yym.entity.Words;
import com.yym.service.PKSocketService;
import com.yym.service.impl.PKSocketServiceImpl;
import com.yym.util.EncoderClassVo;
@Controller
@ServerEndpoint(value="/getServer/{roomid}/{uid}",encoders= {EncoderClassVo.class})
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
	public void onOpen(Session session,@PathParam("roomid")String roomid,@PathParam("uid")String uid) throws IOException, EncodeException {
		//���û����map
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
	public void onMessage(Session session,String code) throws IOException, EncodeException {
		System.out.println(code);
		Map<String,String> map=session.getPathParameters();
		System.out.println("session.getPathParameters:"+map);
		int uid=Integer.parseInt(map.get("uid"));//��ȡ�û���id
		String roomid=map.get("roomid");//��ȡ�û��ķ����
		//�յ�00����Ϣ����ʾҪ����true���ͻ��ˣ��ÿͻ���֪���û��Ѿ����� 
		if(code.equals("t")) {
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendMessage("true",webSocketMap.get(id));
				}
			}
		}else if(code.equals("s")) {//�յ�s����Ϣ����ʾҪ����start���ͻ��ˣ��ÿͻ���֪�����Կ�ʼ��
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendMessage("start",webSocketMap.get(id));
				}
			}
		}else if(code.equals("p")) {//�յ�p����Ϣ����ʾ�û��Ѿ���ʼ��ս��Ҫ����pk�ĵ��ʸ��ͻ���
			List<PKWords> list=this.getPKWords(uid);		
			System.out.println(list);
			for(String id:webSocketUser.keySet()) {
				if(webSocketUser.get(id).equals(roomid)) {
					sendData(list,webSocketMap.get(id));
				}
			}
		}else if(code.equals("n")) {//�յ�n����Ϣ����ʾ�û�˫�����Ѵ����꣬���Խ�����һ����
			for(String id:webSocketUser.keySet()) {//���͸����ֿ��Խ�����һ����
				if(webSocketUser.get(id).equals(roomid)&&Integer.parseInt(id)!=uid) {
					System.out.println(id);
					sendMessage("next",webSocketMap.get(id));
				}
			}
		}
		else {//�����յ������û��ĳɼ������䷢�͸�����
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
		String bank=pkSocketService.selBank(uid);
		List<PKWords> words=new ArrayList<PKWords>();
		String table_name="";
		if(bank=="�������") {
			table_name="highword";
		}else if(bank=="�ļ����") {
			table_name="cet4word";
		}else if(bank=="�������") {
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
			pk.setExplanation(w.getExplanation().split(";")[0]);
			Set<String> s=pkSocketService.selChoose(table_name);
			Set<String> choose=new HashSet<String>();
			for(String str:s) {
				String c=str.split(";")[0];
				choose.add(c);
			}
			choose.add(w.getExplanation().split(";")[0]);
//			s.add(w.getExplanation());
			pk.setChoose(choose);
			words.add(pk);
			index++;
		}
		return words;
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
		if(webSocketNum.get(map.get("roomid"))>1) {
			int num=webSocketNum.get(map.get("roomid"))-1;
			webSocketNum.put(map.get("roomid"), num);
		}else {
			webSocketNum.remove(map.get("roomid"));
		}
		System.out.println(webSocketMap);
		System.out.println(webSocketUser);
		System.out.println(webSocketNum);
	}	
}
