package com.forthenew.springBoard.common.dao;

import java.util.Map;

public interface CommonDao {
	Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception;
}
