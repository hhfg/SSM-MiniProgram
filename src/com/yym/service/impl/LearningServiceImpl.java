package com.yym.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.LearningDao;
import com.yym.entity.UserWords;
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

	@Override
	public int insWords(String tabel_name, String word, String us_pron, String uk_pron, String us_mp3, String uk_mp3,
			String explanation, String val_ex1, String bil_ex1, String val_ex2, String bil_ex2, String val_ex3,
			String bil_ex3, String collocation, int status, Date dates,int bookid) {
		// TODO Auto-generated method stub
		int result=learningDao.insWords(tabel_name, word, us_pron, uk_pron, us_mp3, uk_mp3, explanation, val_ex1, bil_ex1, val_ex2, bil_ex2, val_ex3, bil_ex3, collocation, status, dates, bookid);
		return 0;
	}

	@Override
	public int getCount(String table_name) {
		// TODO Auto-generated method stub
		int count=learningDao.getCount(table_name);
		return count;
	}

	@Override
	public List<UserWords> getWords(String table_name,int status) {
		// TODO Auto-generated method stub
		List<UserWords> list=learningDao.getWords(table_name,status);
		return list;
	}

	@Override
	public int updStatus(String table_name, int id) {
		// TODO Auto-generated method stub
		int result=learningDao.updStatus(table_name, id);
		return result;
	}

	@Override
	public Set<String> selExplanation() {
		// TODO Auto-generated method stub
		Set<String> set=learningDao.selExplanation();
		return set;
	}

	@Override
	public int selLearningCount(String table_name) {
		// TODO Auto-generated method stub
		return learningDao.selLearningCount(table_name);
	}

	@Override
	public List<UserWords> selReview(String table_name, Date dates) {
		// TODO Auto-generated method stub
		return learningDao.selReview(table_name, dates);
	}


}
