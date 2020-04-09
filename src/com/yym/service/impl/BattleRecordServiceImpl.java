package com.yym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.BattleRecordDao;
import com.yym.service.BattleRecordService;

@Service
public class BattleRecordServiceImpl implements BattleRecordService{
	@Autowired
	private BattleRecordDao battleRecordDao;
	
	@Override
	public int insRecord(int playA, int playB, int status) {
		// TODO Auto-generated method stub
		return battleRecordDao.insRecord(playA, playB, status);
	}

	@Override
	public int updRecord(int playB, int status, int id) {
		// TODO Auto-generated method stub
		return battleRecordDao.updRecord(playB, status, id);
	}

	@Override
	public int selId(int playA, int status) {
		// TODO Auto-generated method stub
		return battleRecordDao.selId(playA, status);
	}

}
