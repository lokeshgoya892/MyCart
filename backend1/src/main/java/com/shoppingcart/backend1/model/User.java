package com.shoppingcart.backend1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Table(name="CUser")
@Entity
public class User implements Serializable {

	@Id
	private String userId;
	private int active;
	public int isActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	@Column	(unique=true)
	@NotEmpty(message="name can not be empty")
	private String uname;
	@NotEmpty(message="city can not be empty")
	private String usercity;
	private Long mobileno;
	private String userstate;
	private String usercountry;
	@NotEmpty(message="password can not be empty")
	private String upassword;
	public Long getMobileno() {
		return mobileno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	public String getUsercountry() {
		return usercountry;
	}
	public void setUsercountry(String usercountry) {
		this.usercountry = usercountry;
	}
	
	
	public String getUserstate() {
		return userstate;
	}
	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUsercity() {
		return usercity;
	}
	public void setUsercity(String usercity) {
		this.usercity = usercity;
	}

	
	
	
	
}
