package com.yym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.WordPkDao;
import com.yym.entity.Player;
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
	
}
