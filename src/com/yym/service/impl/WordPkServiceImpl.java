package com.yym.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.WordPkDao;
import com.yym.entity.Player;
import com.yym.entity.Words;
import com.yym.service.WordPkService;

@Service
public class WordPkServiceImpl implements WordPkService{
	@Autowired
	private WordPkDao wordPkDao;
	@Override
	public int updBank(String bank, int uid) {
		// TODO Auto-generated method stub
		return wordPkDao.updBank(bank, uid);
	}
	@Override
	public String selTable(String table_name) {
		// TODO Auto-generated method stub
		return wordPkDao.selTable(table_name);
	}
	@Override
	public int createUserErrorBook(String table_name) {
		// TODO Auto-generated method stub
		return wordPkDao.createUserErrorBook(table_name);
	}
	@Override
	public int insErrorWord(String word, String us_pron, String us_mp3, String explantion, Date dates) {
		// TODO Auto-generated method stub
		return wordPkDao.insErrorWord(word, us_pron, us_mp3, explantion, dates);
	}
}
