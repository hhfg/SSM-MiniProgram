package com.yym.service;

import java.util.List;

import com.yym.entity.Words;

public interface SearchService {
	List<Words> searchWord(String word);
}
