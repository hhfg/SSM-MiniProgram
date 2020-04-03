package com.yym.service;

import com.yym.entity.Player;

public interface WordPkService {
	int updBank(String bank,int uid);
	Player selPlayer(int uid);
}
