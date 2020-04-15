package com.yym.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.yym.entity.PKWords;

import net.sf.json.JSONArray;

public class EncoderClassVo implements Encoder.Text<List<PKWords>>{

    @Override
    public void init(EndpointConfig config) {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

	@Override
	public String encode(List<PKWords> list) throws EncodeException {
		// TODO Auto-generated method stub
		JSONArray jsonObject=JSONArray.fromObject(list);
		return jsonObject.toString();
	}

}

