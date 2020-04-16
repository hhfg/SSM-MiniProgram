package com.yym.service;

import java.util.List;
import java.util.Set;

import com.yym.entity.Player;
import com.yym.entity.Words;

public interface PKSocketService {
	Player selPlayer(int uid);
	List<Words> selPKWords(String table_name);
	Set<String> selChoose(String table_name);
}