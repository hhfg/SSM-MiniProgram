package com.yym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.SignRecordDao;
import com.yym.service.SignRecordService;
@Service
public class SignRecordServiceImpl implements SignRecordService{
	@Autowired
	private SignRecordDao signRecordDao;
	@Override
	public int selUserId(String nickName) {
		// TODO Auto-generated method stub
		return signRecordDao.selUserId(nickName);
	}

	@Override
	public List<String> selSignDate(int uid) {
		// TODO Auto-generated method stub
		return signRecordDao.selSignDate(uid);
	}

}
