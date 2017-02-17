package com.spring.board.exception;

import java.sql.SQLException;

public class ApiCallException extends SQLException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5447986153385060203L;
	public ApiCallException(){}
	public ApiCallException(String message){
		super(message);
	}
}
