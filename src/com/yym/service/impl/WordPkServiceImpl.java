package com.yym.service.impl;

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
	public Player selPlayer(int uid) {
		// TODO Auto-generated method stub
		return wordPkDao.selPlayer(uid);
	}
	@Override
	public List<Words> selPKWords(String table_name) {
		// TODO Auto-generated method stub
		return wordPkDao.selPKWords(table_name);
	}
	@Override
	public Set<String> selChoose(String table_name) {
		// TODO Auto-generated method stub
		return wordPkDao.selChoose(table_name);
	}
	
}
