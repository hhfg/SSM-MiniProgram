package com.yym.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.yym.entity.Player;
import com.yym.entity.Words;

public interface WordPkService {
	int updBank(String bank,int uid);
	String selTable(String table_name);
	int createUserErrorBook(String table_name);
	int insErrorWord(String word,String us_pron,String us_mp3,String explantion,Date dates);
}
