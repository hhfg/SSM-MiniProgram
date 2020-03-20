package com.yym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yym.entity.Words;

public interface SearchDao {
	List<Words> searchWord(@Param("word")String word);
}
