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
//	@Override
//	public int getUserId(String openid) {
//		// TODO Auto-generated method stub
//		int result=userDao.getUserId(openid);
//		return result;
//	}
//	@Override
//	public int insPersonalData(int uid) {
//		// TODO Auto-generated method stub
//		int result=userDao.insPersonalData(uid);
//		return result;
//	}


	@Override
	public int setMyBookId(String username, int bookid) {
		// TODO Auto-generated method stub
		int result=userDao.setMyBookId(username, bookid);
		return result;
	}
	@Override
	public WordBooks selBookByUser(String username) {
		// TODO Auto-generated method stub
		WordBooks wordBook=userDao.selBookByUser(username);
		return wordBook;
	}
	@Override
	public int insPersonalData(int uid,int learningDay,int completedNum,int haveToLearn,int haveToReview,String endTime) {
		// TODO Auto-generated method stub
		int result=userDao.insPersonalData(uid,learningDay,completedNum,haveToLearn,haveToReview,endTime);
		return result;
	}



}
