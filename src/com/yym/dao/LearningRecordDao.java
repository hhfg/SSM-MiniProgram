package com.yym.dao;

import org.apache.ibatis.annotations.Param;

public interface LearningRecordDao {
	//��ȡ�û�����������ѧ�ĵ���
	int selCount(@Param("table_name")String table_name);
}
