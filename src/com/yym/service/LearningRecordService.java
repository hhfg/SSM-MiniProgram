package com.yym.service;

import java.util.Date;

import com.yym.entity.SignRecord;

public interface LearningRecordService {
	SignRecord selDate(Date sign_date,int uid);
	//��ȡ�û�����������ѧ�ĵ���
	int selCountByDate(Date sign_date,int uid);

}
