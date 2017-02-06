package com.spring.board.exception;

public class BoardException extends RuntimeException {
	private String code;
	
	public BoardException(){}
	public BoardException(String message){
		super(message);
	}
	
	public BoardException(String code, String message){
		this(code,message,null);
	}
	
	public BoardException(String code , String message , Throwable cause){
		super(message,cause);
		
		this.code = code;
	}
}
