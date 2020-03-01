package com.yym.service;

import java.util.List;

import com.yym.entity.Words;

public interface LearningService {
	List<Words> selWords(String table,int start,int end);
	String selTableName(String bookName);
}
