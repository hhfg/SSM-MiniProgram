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
	public int insRecord(int roomid,int playA, int status) {
		// TODO Auto-generated method stub
		return battleRecordDao.insRecord(roomid,playA, status);
	}


	@Override
	public int selId(int playA, int status) {
		// TODO Auto-generated method stub
		return battleRecordDao.selId(playA, status);
	}


	@Override
	public int updRecord(int playB, int roomid) {
		// TODO Auto-generated method stub
		return battleRecordDao.updRecord(playB, roomid);
	}

}
