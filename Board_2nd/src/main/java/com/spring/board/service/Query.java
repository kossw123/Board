package com.spring.board.service;

public enum Query {

	GET_BOARD_LIST("_get_board_list","list"),
	UPDATE_BOARD_LIST("_update_board_list","update"),
	INSERT_BOARD_LIST("_insert_board_list","update"),
	DELTE_BOARD_LIST("_delete_board_list","update"),
	VIEW_BOARD_ITEM("_view_board_list","list");
	
	private String query;
	private String type;
	
	private Query(String query,String type){
		this.query = query;
		this.type = type;
	}
	
	public String getQuery() {
		return this.query;
	}
	
	public String getType() {
		return this.type;
	}
}
