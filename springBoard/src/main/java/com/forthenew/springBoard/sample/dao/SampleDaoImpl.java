package com.forthenew.springBoard.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.forthenew.springBoard.common.dao.AbstractDao;

@Repository("sampleDao")
public class SampleDaoImpl extends AbstractDao implements SampleDao {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("sample.selectBoardList", map);
	}

	public void insertBoard(Map<String, Object> map) throws Exception {
	    insert("sample.insertBoard", map);
	}
	
	public void updateHitCnt(Map<String, Object> map) throws Exception {
	    update("sample.updateHitCnt", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
	    return (Map<String, Object>) selectOne("sample.selectBoardDetail", map);
	}
	
	public void updateBoard(Map<String, Object> map) throws Exception {
	    update("sample.updateBoard", map);
	}
	
	public void deleteBoard(Map<String, Object> map) throws Exception {
	    update("sample.deleteBoard", map);
	}
}