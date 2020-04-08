package com.yym.controller;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/getServer/{id}")
public class WebSocketServer {
	@OnOpen
	public void onOpen(Session session,@PathParam("id")int id) {
		System.out.println("sessionId="+session.getId());
		System.out.println("id:"+session.getPathParameters().get("id"));
		//RemoteEndpoint�ӿ�����Ե���һ�˵ĳ���
		final RemoteEndpoint.Basic basic=session.getBasicRemote();
		try {
			basic.sendText("�Ự�����ɹ�");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/* �յ��ͻ�����Ϣʱ���� */
	@OnMessage
	public boolean onMessage(Session session,String message) {
		System.out.println(message);
		System.out.println("sessionId:"+session.getId());
		if(message.equals(session.getPathParameters().get("id"))) {
			return true;
		}else{
			return false;
		}		
	}
	@OnError
	public void onError(Throwable throwable,Session session) {
		System.out.println("sessionId:"+session.getId());
		System.out.println("pathParams:"+session.getPathParameters());
		System.out.println("requestParams:"+session.getRequestParameterMap());
		System.out.println("onError"+throwable.toString());
	}
	@OnClose
	public void onClose(Session session) {
//		System.out.println("pathParams:"+session.getPathParameters());
//		System.out.println("requestParams:"+session.getRequestParameterMap());
		System.out.println("onClose");
	}
	
}
