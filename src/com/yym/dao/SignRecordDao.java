package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SignRecordDao {
	//��ѯ�û�id
	int selUserId(@Param("nickName")String nickName);
	//��ѯ�û��Ĵ�����
	List<String> selSignDate(@Param("uid")int uid);
}
