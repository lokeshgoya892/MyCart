package com.shoppingcart.backend1.DAO;

import java.util.List;

import com.shoppingcart.backend1.model.Product;

public interface ProductDAO {

	boolean addPro(Product p);
	List<Product>getAllProduct();
	public boolean updateProduct(Product p);
	public boolean deleteProduct(int id);
	public Product getProductId(int id);
	List<Product> getProductByCategory(String categoryId);
	
}
