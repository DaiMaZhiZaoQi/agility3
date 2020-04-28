package com.agility.common;

/**
 * 公用返回Result
 * @author williambai
 *
 */
public class Result {
	private int code;
	private String msg;
	private Object data="";
	
	public Result(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	

	public static Result success() {
		return new Result(ResponseCode.success.getCode(),ResponseCode.success.getMsg());
	}
	
	public static Result error() {
		return new Result(ResponseCode.err.getCode(),ResponseCode.err.getMsg());
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
	

}
