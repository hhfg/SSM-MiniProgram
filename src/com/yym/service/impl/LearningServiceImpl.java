package com.yym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.LearningDao;
import com.yym.entity.Words;
import com.yym.service.LearningService;

@Service
public class LearningServiceImpl implements LearningService{
	@Autowired
	private LearningDao learningDao;

	@Override
	public List<Words> selWords(String table,int start,int end) {
		// TODO Auto-generated method stub
		List<Words> word=learningDao.selWords(table,start,end);
		return word;
	}

	@Override
	public String selTableName(String bookName) {
		// TODO Auto-generated method stub
		String tableName=learningDao.selTableName(bookName);
		return tableName;
	}

}
