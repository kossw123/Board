package com.spring.board.service.dao;

import java.sql.Date;

public class UserDao {
	private String id;
	private String name;
	private Date reg_date;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDao [id=" + id + ", name=" + name + ", reg_date="
				+ reg_date + ", password=" + password + "]";
	}
}
