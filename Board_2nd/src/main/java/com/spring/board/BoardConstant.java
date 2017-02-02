package com.spring.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.service.UserDao;

@Controller
public class BoardConstant {
	
	@RequestMapping(value="/*.page", method=RequestMethod.GET)
	public Model getPage(HttpServletRequest request, Model model){
		return model;
	}
}
