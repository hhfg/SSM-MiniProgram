package com.yym.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.LearningRecordDao;
import com.yym.entity.SignRecord;
import com.yym.service.LearningRecordService;
@Service
public class LearningRecordServiceImpl implements LearningRecordService{
	@Autowired
	private LearningRecordDao learningRecordDao;
	
	@Override
	public int selCountByDate(Date sign_date, int uid) {
		// TODO Auto-generated method stub
		return learningRecordDao.selCountByDate(sign_date, uid);
	}

	@Override
	public SignRecord selDate(Date sign_date, int uid) {
		// TODO Auto-generated method stub
		return learningRecordDao.selDate(sign_date, uid);
	}

}
