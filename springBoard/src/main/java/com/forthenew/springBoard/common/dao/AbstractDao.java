package com.forthenew.springBoard.common.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class AbstractDao {
	protected Logger log = LoggerFactory.getLogger(AbstractDao.class);

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	public Object insert(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}
	
	public Object update(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.update(queryId, params);
	}

	public Object delete(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}
	
	public Object selectOne(String queryId){
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}
	
	public Object selectOne(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		printQueryId(queryId);
		return sqlSession.selectList(queryId);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.selectList(queryId,params);
	}
	
	@SuppressWarnings("unchecked")
	public Object selectPagingList(String queryId, Object params) {
		printQueryId(queryId);
		Map<String, Object> map = (Map<String, Object>)params;
		
		String	strPageIndex	= (String)map.get("PAGE_INDEX");
		String	strPageRow		= (String)map.get("PAGE_ROW");
		int		nPageIndex		= 0;
		int		nPageRow		= 20;
		
		if(!StringUtils.isEmpty(strPageIndex)) {
			nPageIndex		= Integer.parseInt(strPageIndex)-1;
		}
		if(!StringUtils.isEmpty(strPageRow)) {
			nPageRow		= Integer.parseInt(strPageRow);
		}
		map.put("START", (nPageIndex*nPageRow)+1);
		map.put("END", (nPageIndex*nPageRow)+nPageRow);
		
		return sqlSession.selectList(queryId, map);
	}
}
