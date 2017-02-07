package com.spring.board.service;

public enum Query {

	GET_BOARD_LIST("select seq, id, title, content, reg_date, mod_date  from user.board","list"),
	UPDATE_BOARD_LIST("update board set id=:id, title=:title,content=:content,mod_date=now() where seq=:seq","update"),
	INSERT_BOARD_LIST("insert into user.board (id, title, content, reg_date, mod_date) values(:id,:title,:content,now(),now())","update"),
	DELTE_BOARD_LIST("delete from user.board where seq = :seq","update"),
	VIEW_BOARD_ITEM("select id, title, content, reg_date, mod_date from user.board where seq = :seq","list");
	
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
