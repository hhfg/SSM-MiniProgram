package com.yym.service;

import java.util.List;

public interface SignRecordService {
	//��ѯ�û�id
	int selUserId(String nickName);
	//��ѯ�û��Ĵ�����
	List<String> selSignDate(int uid);
}
