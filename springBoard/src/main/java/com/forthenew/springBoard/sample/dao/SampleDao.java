package com.forthenew.springBoard.sample.dao;

import java.util.List;
import java.util.Map;

public interface SampleDao {
	List<Map<String, Object>> selectBoardList(Map<String, Object> map);
	void insertBoard(Map<String, Object> map) throws Exception;
	void updateHitCnt(Map<String, Object> map) throws Exception;
	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;
	void updateBoard(Map<String, Object> map) throws Exception;
	void deleteBoard(Map<String, Object> map) throws Exception;
	void insertFile(Map<String, Object> map) throws Exception;
}