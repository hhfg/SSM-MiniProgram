package com.yym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.yym.dao.LearningRecordDao;
import com.yym.service.LearningRecordService;

public class LearningRecordServiceImpl implements LearningRecordService{
	@Autowired
	private LearningRecordDao learningRecordDao;
	@Override
	public int selCount(String table_name) {
		// TODO Auto-generated method stub
		return learningRecordDao.selCount(table_name);
	}

}
