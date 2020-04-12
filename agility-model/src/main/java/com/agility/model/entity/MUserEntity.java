package com.agility.model.entity;

/**
 * 用户实体
 * @author williambai
 *
 */
public class MUserEntity extends MBaseEntity{

	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
