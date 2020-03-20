package com.yym.dao;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.Words;

public interface SearchDao {
	Words searchWord(@Param("word")String word);
}
