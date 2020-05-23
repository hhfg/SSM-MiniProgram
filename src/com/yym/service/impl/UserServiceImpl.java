package com.yym.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.UserDao;
import com.yym.entity.PersonalData;
import com.yym.entity.SignRecord;
import com.yym.entity.User;
import com.yym.entity.UserWords;
import com.yym.entity.WordBooks;
import com.yym.entity.Words;
import com.yym.service.UserService;
@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User selUser(String openid) {
		// TODO Auto-generated method stub
		return userDao.selUser(openid);
	}
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
	public int insPersonalData(int uid,int clockInDay,Date startUseDate,String bank) {
		// TODO Auto-generated method stub
		int result=userDao.insPersonalData(uid,clockInDay,startUseDate,bank);
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
	public int updPersonalData(PersonalData personalData) {
		// TODO Auto-generated method stub
		int result=userDao.updPersonalData(personalData);
		return result;
	}
	@Override
	public int createUserWordTable(String tableName) {
		// TODO Auto-generated method stub
		int result=userDao.createUserWordTable(tableName);
		return result;
	}
	@Override
	public int selReviewCount(String table_name, Date dates) {
		// TODO Auto-generated method stub
		return userDao.selReviewCount(table_name, dates);
	}
	@Override
	public int selLearningCount(String table_name, Date dates, int bookid) {
		// TODO Auto-generated method stub
		return userDao.selLearningCount(table_name, dates, bookid);
	}
	@Override
	public List<Words> selWords(String table, int start, int end) {
		// TODO Auto-generated method stub
		return userDao.selWords(table, start, end);
	}
	@Override
	public int insWords(String tabel_name, String word, String us_pron, String uk_pron, String us_mp3, String uk_mp3,
			String explanation, String val_ex1, String bil_ex1, String val_ex2, String bil_ex2, String val_ex3,
			String bil_ex3, String collocation, int status, Date dates, int bookid,int collect) {
		// TODO Auto-generated method stub
		return userDao.insWords(tabel_name, word, us_pron, uk_pron, us_mp3, uk_mp3, explanation, val_ex1, bil_ex1, val_ex2, bil_ex2, val_ex3, bil_ex3, collocation, status, dates, bookid, collect);
	}
	@Override
	public String selTableName(int id) {
		// TODO Auto-generated method stub
		return userDao.selTableName(id);
	}
	@Override
	public int selCountToday(String table_name, Date dates,int bookid) {
		// TODO Auto-generated method stub
		return userDao.selCountToday(table_name, dates,bookid);
	}
	@Override
	public int insSignRecord(SignRecord signRecord) {
		// TODO Auto-generated method stub
		return userDao.insSignRecord(signRecord);
	}
	@Override
	public SignRecord selSignRecord(int uid, Date sign_date) {
		// TODO Auto-generated method stub
		return userDao.selSignRecord(uid, sign_date);
	}
	@Override
	public List<UserWords> selNotLearned(String table_name,int bookid) {
		// TODO Auto-generated method stub
		return userDao.selNotLearned(table_name,bookid);
	}
	@Override
	public SignRecord selTodaySign(int uid, Date sign_date) {
		// TODO Auto-generated method stub
		return userDao.selTodaySign(uid, sign_date);
	}
	@Override
	public int updSignRecord(int learned_num, int uid,Date sign_date) {
		// TODO Auto-generated method stub
		return userDao.updSignRecord(learned_num, uid,sign_date);
	}
	@Override
	public int insPlayer(int uid, String nickName,String bank) {
		// TODO Auto-generated method stub
		return userDao.insPlayer(uid, nickName,bank);
	}
	@Override
	public int selWordNum(int id) {
		// TODO Auto-generated method stub
		return userDao.selWordNum(id);
	}
	
}
