package com.spring.board.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.board.exception.ApiCallException;

@Service
public class ApiCallSerivce {
	
	@Autowired
	private JdbcTemplate template;
	
	public ApiCallSerivce(){
		
	}
	
	public Map<String,Object> call(Query query,Map<String,Object> reqMap) throws SQLException{
		Map<String,Object> resMap = new HashMap<String,Object>();
		resMap.put("result",this.execute(query,reqMap));
	
		return resMap;
	}
	
	public Map<String,Object> execute(Query query,Map<String,Object> reqMap) throws SQLException{
		
		if(query.getQuery_type().equals("select")){
			return this.callMap(query, reqMap);
		}else{
			return this.callUpdate(query, reqMap);
		}
	}
	
	public Map<String,Object> callMap(Query query, Map<String,Object> reqMap) throws SQLException{
		
		Map<String,Object> resMap;
		try{
			Map<String,Object> resultMap = this.template.queryForMap(query.getQuery());
			
			if(resultMap.isEmpty() || resultMap == null){
				throw new ApiCallException("게시물이 존재하지 않습니다.");
			}
			resMap = resultMap;
		}catch(EmptyResultDataAccessException e){
			throw new ApiCallException("게시물이 존재하지 않습니다.");
		}
		
		return resMap;
		
	}
	
	public Map<String,Object> callUpdate(Query query,Map<String,Object> reqMap){
		
		int res_value = 0;
		Map<String,Object> resMap = new HashMap<String,Object>();
		
		if(res_value == 1){
			resMap.put("message", true);
		}else{
			resMap.put("message",false);
		}
		
		return resMap;
	}
}
