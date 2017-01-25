package com.spring.board.service;

public enum Query {

	GET_BOARD_LIST("select * from user.board","select");
	
	private String query;
	private String query_type;
	
	private Query(String query,String query_type){
		this.query = query;
		this.query_type = query_type;
	}
	
	public String getQuery() {
		return this.query;
	}

	public String getQuery_type() {
		return query_type;
	}
	
}
