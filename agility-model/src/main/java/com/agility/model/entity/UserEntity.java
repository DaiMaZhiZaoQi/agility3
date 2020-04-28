package com.agility.model.entity;


import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


//@Data		// lombok
//@ToString
//@Entity		//  jpa
//@TableName(name = "user")
@TableName("user")
public class UserEntity extends MBaseEntity{

//	@Id
//	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @TableId(value = "user_id", type = IdType.AUTO)
	private Integer id;
	
	private String name;
	
	private String password;
	


	
	private String userAddress;

	private Integer departmentId;
	
	private Date gmtCreate;



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




	public Integer getDepartmentId() {
		return departmentId;
	}




	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}




	public Date getGmtCreate() {
		return gmtCreate;
	}




	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	
	
}
