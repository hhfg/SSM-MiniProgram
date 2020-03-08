package com.yym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.UserDao;
import com.yym.entity.PersonalData;
import com.yym.entity.User;
import com.yym.entity.WordBooks;
import com.yym.service.UserService;
@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public int insUser(User user) {
		// TODO Auto-generated method stub
		int result=userDao.insUser(user);
		return result;
	}
	@Override
	public int getUserId(String openid) {
		// TODO Auto-generated method stub
		int id=userDao.getUserId(openid);
		return id;
	}
	@Override
	public int insPersonalData(int uid,int clockInDay) {
		// TODO Auto-generated method stub
		int result=userDao.insPersonalData(uid,clockInDay);
		return result;
	}
	@Override
	public int getUserIdByName(String nickName) {
		// TODO Auto-generated method stub
		int result=userDao.getUserIdByName(nickName);
		return result;
	}

	@Override
	public PersonalData selPersonalData(int uid) {
		// TODO Auto-generated method stub
		PersonalData p=userDao.selPersonalData(uid);
		return p;
	}
	@Override
	public int setMyBook(int bookid, int uid) {
		// TODO Auto-generated method stub
		int result=userDao.setMyBook(bookid,uid);
		return result;
	}
	@Override
	public int updPersonalData(int haveToLearn, String endTime,int learningDay) {
		// TODO Auto-generated method stub
		int result=userDao.updPersonalData(haveToLearn, endTime,learningDay);
		return result;
	}
	@Override
	public int createUserWordTable(String tableName) {
		// TODO Auto-generated method stub
		int result=userDao.createUserWordTable(tableName);
		return result;
	}
	


}
