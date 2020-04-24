package com.yym.service;

import java.util.List;
import java.util.Set;

import com.yym.entity.User;
import com.yym.entity.Words;

public interface PKSocketService {
	List<Words> selPKWords(String table_name);
	Set<String> selChoose(String table_name);
	String selBank(int uid);
	User selUser(int id);
}
