package com.forthenew.springBoard.common.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository("commonDao")
public class CommonDaoImpl extends AbstractDao implements CommonDao {
	@SuppressWarnings("unchecked")
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
	    return (Map<String, Object>)selectOne("common.selectFileInfo", map);
	}
}
