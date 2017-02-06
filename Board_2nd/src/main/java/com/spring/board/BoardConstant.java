package com.spring.board;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.service.UserDao;
import com.spring.board.util.HashUtil;

@Controller
public class BoardConstant {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/*.page", method=RequestMethod.GET)
	public Model getPage(HttpServletRequest request, Model model){
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		
		this.logger.info(uuid);
		
		String hashUUID1 = HashUtil.getPassword(uuid, "1609230");
		String hashUUID2 = HashUtil.getPassword(uuid, "16092300");
		
		if(hashUUID1.length() > 32){
			hashUUID1 = hashUUID1.substring(0,31);
		}
		
		if(hashUUID2.length() > 32){
			hashUUID2 = hashUUID2.substring(0,31);
		}
		
		this.logger.info(hashUUID1);
		this.logger.info(hashUUID2);
		
		return model;
	}
}
