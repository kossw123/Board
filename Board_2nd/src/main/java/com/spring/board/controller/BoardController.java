package com.spring.board.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.service.ApiCallSerivce;
import com.spring.board.service.Query;


@Controller
public class BoardController {
	
	Query query;
	
	@Autowired
	private ApiCallSerivce apiCallService;
	
	
	
	@RequestMapping(value="/getBoardList.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> getBoardList(HttpServletRequest request,@RequestBody Map<String,Object>reqMap){
		Map<String,Object> resMap = this.apiCallService.call(query.GET_BOARD_LIST, reqMap);
		
		return resMap;
	}
	
	@RequestMapping(value="/deleteBoardList.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteBoardList(HttpServletRequest request,@RequestBody Map<String,Object>reqMap){
		Map<String,Object> resMap = null;
		
		return resMap;
	}
	
	@RequestMapping(value="/writeBoardList.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> writeBoardList(HttpServletRequest request,@RequestBody Map<String,Object>reqMap){
		Map<String,Object> resMap = null;
		
		return resMap;
	}
	
	@RequestMapping(value="/updateBoardList.json", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateBoardList(HttpServletRequest request,@RequestBody Map<String,Object>reqMap){
		Map<String,Object> resMap = null;
		
		return resMap;
	}
}
