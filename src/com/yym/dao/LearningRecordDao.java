package com.yym.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.SignRecord;

public interface LearningRecordDao {
	SignRecord selDate(@Param("sign_date")Date sign_date,@Param("uid")int uid);
	//��ȡ�û�����������ѧ�ĵ���
	int selCountByDate(@Param("sign_date")Date sign_date,@Param("uid")int uid);
}
