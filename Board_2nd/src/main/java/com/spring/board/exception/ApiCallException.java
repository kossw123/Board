package com.spring.board.exception;

import java.sql.SQLException;

public class ApiCallException extends SQLException {
	public ApiCallException(){}
	public ApiCallException(String message){
		super(message);
	}
}
