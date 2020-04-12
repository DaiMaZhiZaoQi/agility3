package com.agility.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data		// lombok
@ToString
@Entity		//  jpa
@Table(name = "user")
public class UserEntity extends MBaseEntity{

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String password;
	


	
	@Column(name = "user_address")
	private String userAddress;




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getUserAddress() {
		return userAddress;
	}




	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	
	
}
