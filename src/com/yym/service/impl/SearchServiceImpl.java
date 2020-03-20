package com.yym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.dao.SearchDao;
import com.yym.entity.Words;
import com.yym.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{
	@Autowired
	private SearchDao searchDao;
	
	@Override
	public Words searchWord(String word) {
		// TODO Auto-generated method stub
		return searchDao.searchWord(word);
	}

}
