package com.forthenew.springBoard.common.controller;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.forthenew.springBoard.common.common.CommandMap;
import com.forthenew.springBoard.common.service.CommonService;

@Controller
public class CommonController {
	Logger log = LoggerFactory.getLogger(this.getClass());
    
	@Resource(name="commonService")
	private CommonService commonService;
	
	@RequestMapping(value="/common/downloadFile.do")
	public void downloadFile(CommandMap commandMap, HttpServletResponse response) throws Exception {
		Map<String,Object> map = commonService.selectFileInfo(commandMap.getMap());
		String storedFileName = (String)map.get("STORED_FILE_NAME");
		String originalFileName = (String)map.get("ORIGINAL_FILE_NAME");
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("/media/forthenew/download/test_file/"+storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
//		페이지에서 가이드한 방식, 아마도 IE용인듯.		
//		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
//		파이어폭스 용
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + new String(originalFileName.getBytes("UTF-8"), "ISO-8859-1") + "\";");
		
//		String header = getBrowser(request);
//		if (header.contains("MSIE")) {
//			String docName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
//			response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
//		} else if (header.contains("Firefox")) {
//			String docName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//			response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
//		} else if (header.contains("Opera")) {
//			String docName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//			response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
//		} else if (header.contains("Chrome")) {
//			String docName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
//			response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
//		}
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.getOutputStream().write(fileByte);
		
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
//	private String getBrowser(HttpServletRequest request) {
//		String header =request.getHeader("User-Agent");
//		
//		if (header.contains("MSIE")) {
//			return "MSIE";
//		} else if(header.contains("Chrome")) {
//			return "Chrome";
//		} else if(header.contains("Opera")) {
//			return "Opera";
//		}
//		return "Firefox";
//	}
}
