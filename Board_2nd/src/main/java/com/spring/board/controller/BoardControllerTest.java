package com.spring.board.controller;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.board.service.ApiCallSerivce;
import com.spring.board.service.Query;

public class BoardControllerTest {
	
	Query query ;
	
	@Test
	public void testGetBoardList() {
		ApiCallSerivce apiCallSerivce = new ApiCallSerivce();
		
		Map<String,Object> reqMap = new HashMap<String, Object>();
		System.out.println(apiCallSerivce);
		assertTrue(apiCallSerivce.call(query.GET_BOARD_LIST, reqMap).isEmpty());
	}

}
