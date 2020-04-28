package com.agility.common;

public enum ResponseCode {

	
	success(1000,"操作成功"),
	err(1001,"错误");
	
	
	private int code;
	private String msg;
	 ResponseCode(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	public void setCode(int code) {
		this.code=code;
	}
	public void setMsg(String msg) {
		this.msg=msg;
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	
}
