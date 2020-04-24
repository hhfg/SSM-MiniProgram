package com.yym.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.PKSocketDao;
import com.yym.entity.User;
import com.yym.entity.Words;
import com.yym.service.PKSocketService;

@Service
public class PKSocketServiceImpl implements PKSocketService{
	@Autowired
	private PKSocketDao pkSocketDao;

	@Override
	public List<Words> selPKWords(String table_name) {
		// TODO Auto-generated method stub
		return pkSocketDao.selPKWords(table_name);
	}

	@Override
	public Set<String> selChoose(String table_name) {
		// TODO Auto-generated method stub
		return pkSocketDao.selChoose(table_name);
	}

	@Override
	public String selBank(int uid) {
		// TODO Auto-generated method stub
		return pkSocketDao.selBank(uid);
	}

	@Override
	public User selUser(int id) {
		// TODO Auto-generated method stub
		return pkSocketDao.selUser(id);
	}

}
