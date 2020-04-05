package com.yym.controller;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/getServer")
public class WebSocketServer {
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("sessionId="+session.getId());
		//RemoteEndpoint�ӿ�����Ե���һ�˵ĳ���
		final RemoteEndpoint.Basic basic=session.getBasicRemote();
		try {
			basic.sendText("�Ự�����ɹ�");
		}catch(IOException e) {
			e.printStackTrace();
		}
		//�����߳�
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("�����̣߳�");
				// TODO Auto-generated method stub
				try {
					Thread.currentThread();
					Thread.sleep(8000);
					basic.sendText("server get you a msg:what your name?");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			
		});
		t1.start();
	}

	/* �յ��ͻ�����Ϣʱ���� */
	@OnMessage
	public String onMessage(Session session,String message) {
		System.out.println("sessionId:"+session.getId());
		System.out.println("pathParams:"+session.getPathParameters());
		System.out.println("requestParams"+session.getRequestParameterMap());
		return "Got your message!"+message;
		
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
		System.out.println("sessionId:"+session.getId());
		System.out.println("pathParams:"+session.getPathParameters());
		System.out.println("requestParams:"+session.getRequestParameterMap());
		System.out.println("onClose");
	}
	
}
