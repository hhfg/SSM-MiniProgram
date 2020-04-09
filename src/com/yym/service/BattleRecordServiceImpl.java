package com.yym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.BattleRecordDao;

@Service
public class BattleRecordServiceImpl implements BattleRecordService{
	@Autowired
	private BattleRecordDao battleRecordDao;
	
	@Override
	public int insRecord(int playA, int status) {
		// TODO Auto-generated method stub
		return battleRecordDao.insRecord(playA, status);
	}

}
