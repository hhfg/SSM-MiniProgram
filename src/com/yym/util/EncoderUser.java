package com.yym.util;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.qiniu.util.Json;
import com.yym.entity.User;

public class EncoderUser implements Encoder.Text<User>{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(User u) throws EncodeException {
		// TODO Auto-generated method stub
		return Json.encode(u);
	}

}
