package com.spring.board;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardConstant {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/*.page", method=RequestMethod.GET)
	public Model getPage(HttpServletRequest request, Model model){
		
		if(logger.isDebugEnabled()){
			logger.debug("요청된 페이지  " + request.getRequestURL().toString());
		}
		
		return model;
	}
}
