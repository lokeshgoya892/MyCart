package  com.shoppingcart.backend1.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
@Component 
@Entity
public class Author {
	@Id
	String role_id;
	String uname;
	String role;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

	public Author()
	{
		role_id="ROLE"+UUID.randomUUID().toString().substring(10).toUpperCase();
		
	}

	
	
	}

	
