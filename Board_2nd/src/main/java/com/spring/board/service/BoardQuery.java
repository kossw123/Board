package com.spring.board.service;

public class BoardQuery {
	public String _get_board_list(){
		return "select seq, id, title, content, reg_date, mod_date  from user.board";
	}
	
	public String _update_board_list(){
		return "update board set id=:id, title=:title,content=:content,mod_date=now() where seq=:seq";
	}
	
	public String _insert_board_list(){
		return "insert into user.board (id, title, content, reg_date, mod_date) values(:id,:title,:content,now(),now())";
	}
	
	public String _delete_board_list(){
		return "delete from user.board where seq = :seq";
	}
	
	public String _view_board_list(){
		return "select id, title, content, reg_date, mod_date from user.board where seq = :seq";
	}
}
