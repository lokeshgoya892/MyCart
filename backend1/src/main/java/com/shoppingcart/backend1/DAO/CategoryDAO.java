package com.shoppingcart.backend1.DAO;

import java.util.List;

import com.shoppingcart.backend1.model.Category;


public interface CategoryDAO
{

    boolean addCat(Category c);
	List<Category> getAllCategory();

	public boolean update(Category c);
	public boolean deleteCat(String id);
	public Category getCategoryId(String id);
}
