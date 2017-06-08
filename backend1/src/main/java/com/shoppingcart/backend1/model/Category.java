package com.shoppingcart.backend1.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;
@Component 
@Entity

public class Category implements Serializable {
	@Id
	private String catId;
	@Column	(unique=true)
	private String cname;
	private String cdesc;
	@OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	Set<Product>product;
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public Set<Product> getProducts() {
		return product;
	}
	public void setProducts(Set<Product> products) {
		this.product = products;
	}
	
	
		
}
