package com.agility.model.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//@Data		// lombok
//@ToString
//@Entity		//  jpa
//@TableName(name = "user")
/**
 * 实现userDetail 是为了遵守SpringSecurity开发规范，在SpringSecurity中默认的有该类的字段
 * @author williambai
 *
 */
@TableName("user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity extends MBaseEntity implements UserDetails{

//	@Id
//	@Column(name = "user_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @TableId(value = "user_id", type = IdType.AUTO)
	private Integer id;
	
	private String username;
	
	private String password;
	
	private boolean accountNonExpired;
	
	private boolean accountNonLocked;
	
	private boolean credentialsNonExpired;
	
	private boolean enabled;
	
	
	@TableField(exist = false)
	private List<Role> roles;
	
	@JsonIgnore
	@TableField(exist = false)
	private List<GrantedAuthority>  authorities;
	
	private String userAddress;

	private Integer departmentId;
	
	private Date gmtCreate;



	public UserEntity() {
		super();
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
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

	





	/**
	 * get授权
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
		List<Role> roles2 = getRoles(); 
		System.out.println("role-->"+roles2.size());
		for(Role role:roles2) {
			
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}

	

	


	public void setUsername(String username) {
		this.username = username;
	}




	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}




	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}




	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	public List<Role> getRoles() {
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}



	/**
	 * 账户是否过期
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return accountNonExpired;
	}



	/**
	 * 账户锁定
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return accountNonLocked;
	}



	/**
	 * 证书是否i过期
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return credentialsNonExpired;
	}



	/**
	 * 是否可用
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}
	
	
	
}
