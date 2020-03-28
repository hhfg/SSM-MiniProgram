package com.yym.service;

import java.util.Date;

import com.yym.entity.SignRecord;

public interface LearningRecordService {
	SignRecord selDate(Date sign_date,int uid);
	//获取用户单词书中已学的单词
	int selCountByDate(Date sign_date,int uid);

}
