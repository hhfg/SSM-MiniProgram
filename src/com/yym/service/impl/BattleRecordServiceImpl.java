package com.yym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.BattleRecordDao;
import com.yym.entity.BattleRecord;
import com.yym.entity.User;
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
	public int updRecord(int playB, int status, int roomid) {
		// TODO Auto-generated method stub
		return battleRecordDao.updRecord(playB, status, roomid);
	}


	@Override
	public User selUser(int id) {
		// TODO Auto-generated method stub
		return battleRecordDao.selUser(id);
	}


	@Override
	public int selId(BattleRecord battleRecord) {
		// TODO Auto-generated method stub
		return battleRecordDao.selId(battleRecord);
	}

	@Override
	public BattleRecord selUid(int id) {
		// TODO Auto-generated method stub
		return battleRecordDao.selUid(id);
	}

}
