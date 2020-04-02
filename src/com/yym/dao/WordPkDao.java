package com.yym.dao;

import org.apache.ibatis.annotations.Param;

public interface WordPkDao {
	int updBankId(@Param("bankId")int bankId,@Param("uid")int uid);
}
