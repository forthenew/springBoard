package com.forthenew.springBoard.sample.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.forthenew.springBoard.common.util.FileUtils;
import com.forthenew.springBoard.sample.dao.SampleDao;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Resource(name="fileUtils")
    private FileUtils fileUtils;
	
    @Resource(name="sampleDao")
    private SampleDao sampleDao;
    
	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return sampleDao.selectBoardList(map);
	}
	
	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) throws Exception {
		sampleDao.insertBoard(map);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
        for(int i = 0; i < list.size(); i++) {
            sampleDao.insertFile(list.get(i));
        }
	}
	
	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
	    sampleDao.updateHitCnt(map);
	    Map<String, Object> resultMap = new HashMap<String,Object>();
	    
	    Map<String, Object> tempMap = 	sampleDao.selectBoardDetail(map);
	    resultMap.put("map", tempMap);
	    
	    List<Map<String, Object>> list = sampleDao.selectFileList(map);
	    resultMap.put("list", list);
	    
	    return resultMap;
	}
	
	@Override
	public void updateBoard(Map<String, Object> map, HttpServletRequest request) throws Exception{
		sampleDao.updateBoard(map);
	    
		sampleDao.deleteFileList(map);
		List<Map<String, Object>> list = fileUtils.parseUpdateFileInfo(map, request);
		Map<String, Object> tempMap = null;
		for( int i = 0; i < list.size(); i++) {
			tempMap = list.get(i);
			if( tempMap.get("IS_NEW").equals("Y")) {
				sampleDao.insertFile(tempMap);
			}
			else
			{
				sampleDao.updateFile(tempMap);
			}
		}
	}
	
	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
	    sampleDao.deleteBoard(map);
	}
}