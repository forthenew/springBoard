package com.forthenew.springBoard.sample.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
	Logger log = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value="/sample/openSampleList.do")
    public ModelAndView openSampleList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("");
        log.debug("인터셉터 테스트");
         
        return mv;
    }
}
