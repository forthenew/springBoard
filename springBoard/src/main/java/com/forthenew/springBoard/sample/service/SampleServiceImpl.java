package com.forthenew.springBoard.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.forthenew.springBoard.sample.dao.SampleDao;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {

	Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource(name="sampleDao")
    private SampleDao sampleDao;
    
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return sampleDao.selectBoardList(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map) throws Exception {
	    sampleDao.insertBoard(map);
	}
	
	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
	    sampleDao.updateHitCnt(map);
	    Map<String, Object> resultMap = sampleDao.selectBoardDetail(map);
	    return resultMap;
	}
	
	@Override
	public void updateBoard(Map<String, Object> map) throws Exception{
	    sampleDao.updateBoard(map);
	}
	
	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
	    sampleDao.deleteBoard(map);
	}
}