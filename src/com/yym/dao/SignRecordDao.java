package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SignRecordDao {
	//查询用户id
	int selUserId(@Param("nickName")String nickName);
	//查询用户的打卡日期
	List<String> selSignDate(@Param("uid")int uid);
}
