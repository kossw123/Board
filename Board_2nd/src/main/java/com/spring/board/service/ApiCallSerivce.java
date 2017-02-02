package com.spring.board.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.spring.board.exception.ApiCallException;

@Service
public class ApiCallSerivce {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate template;
	@Autowired
	private NamedParameterJdbcTemplate namedTemplate;
	
	public ApiCallSerivce() {

	}

	public Map<String, Object> call(Query query, Map<String, Object> reqMap)
			throws SQLException {
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("result", this.execute(query, reqMap));

		return resMap;
	}

	public Object execute(Query query, Map<String, Object> reqMap)
			throws SQLException {

		if (query.getQuery_type().equals("select")) {
			return this.callList2(query, reqMap);
		} else {
			return this.callUpdate2(query, reqMap);
		}
	}

	public Object callMap(Query query, Map<String, Object> reqMap)
			throws SQLException {

		Map<String, Object> resMap;
		try {
			Map<String, Object> resultMap = this.template.queryForMap(query
					.getQuery());

			if (resultMap.isEmpty() || resultMap == null) {
				throw new ApiCallException("게시물이 존재하지 않습니다.");
			}
			resMap = resultMap;
		} catch (EmptyResultDataAccessException e) {
			throw new ApiCallException("게시물이 존재하지 않습니다.");
		}

		return resMap;

	}

	public Object callList(Query query, Map<String, Object> reqMap)
			throws SQLException {
		List<Map<String, Object>> resList;
		try {

			List<Map<String, Object>> list = this.template.queryForList(query
					.getQuery());
			if (list.isEmpty() || list == null) {
				throw new ApiCallException("게시물이 존재하지 않습니다.");
			}

			resList = list;
		} catch (EmptyResultDataAccessException e) {
			throw new ApiCallException("게시물이 존재하지 않습니다.");
		} catch (ApiCallException e) {
			throw new ApiCallException("게시물이 존재하지 않습니다.");
		} catch (Exception e) {
			throw new ApiCallException("나머지 오류");
		}

		return resList;
	}

	public Map<String, Object> callUpdate(Query query,
			Map<String, Object> reqMap) {

		int res_value = this.template.update(query.getQuery(),reqMap);
		Map<String, Object> resMap = new HashMap<String, Object>();

		if (res_value == 1) {
			resMap.put("message", true);
		} else {
			resMap.put("message", false);
		}

		return resMap;
	}
	
	public Object callList2(Query query, Map<String, Object> reqMap)
			throws SQLException {
		List<Map<String, Object>> resList;
		try {

			List<Map<String, Object>> list = this.namedTemplate.queryForList(query.getQuery(), reqMap);
			
			if (list.isEmpty() || list == null) {
				throw new ApiCallException("게시물이 존재하지 않습니다.");
			}

			resList = list;
		} catch (EmptyResultDataAccessException e) {
			throw new ApiCallException("게시물이 존재하지 않습니다.");
		} catch (ApiCallException e) {
			throw new ApiCallException("게시물이 존재하지 않습니다.");
		} catch (Exception e) {
			throw new ApiCallException("나머지 오류");
		}

		return resList;
	}
	
	public Map<String, Object> callUpdate2(Query query,
			Map<String, Object> reqMap) throws SQLException {
		
		logger.info(reqMap.toString());
		logger.info(query.getQuery());
		
		reqMap.put("reg_date", new Date(System.currentTimeMillis()));
		reqMap.put("mod_date", new Date(System.currentTimeMillis()));
		
		int res_value = this.namedTemplate.update(query.getQuery(), reqMap);
		Map<String, Object> resMap = new HashMap<String, Object>();

		if (res_value == 1) {
			resMap.put("message", true);
		} else {
			throw new ApiCallException("데이터 입력 실패");
		}

		return resMap;
	}
}
