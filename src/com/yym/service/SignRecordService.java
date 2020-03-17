package com.yym.service;

import java.util.List;

public interface SignRecordService {
	//查询用户id
	int selUserId(String nickName);
	//查询用户的打卡日期
	List<String> selSignDate(int uid);
}
