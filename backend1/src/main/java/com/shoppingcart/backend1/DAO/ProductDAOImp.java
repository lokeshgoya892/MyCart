package com.shoppingcart.backend1.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shoppingcart.backend1.model.Product;

@Repository("productDAO")

public class ProductDAOImp  implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean addPro(Product p) 
	{
		 Session session = sessionFactory.getCurrentSession();		
		  try
		  {
			 
				  session.persist(p);
			  return true;
		  }
		  catch (Exception e) 
		  {
		  e.printStackTrace();
		  return false;
		  }	
	}
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query qu=session.createQuery("from Product");
		List<Product> productList=(List<Product>)qu.list();
		return productList;
	}

	@Transactional
	public Product getProductId(int id) 
	{
		Session ss=sessionFactory.getCurrentSession();
		return (Product) ss.get(Product.class , id);
		
	}
	
	@Transactional
	public List<Product> getProductByCategory(String categoryId)
	{
    Session session=sessionFactory.getCurrentSession();
    Query query=session.createQuery("from Product where categoryId=?");
    query.setString(0, categoryId);
    List<Product> productList = (List<Product>) query.list();
    return productList;
	}

	@Transactional
	public boolean updateProduct(Product p) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(p);
			return true;
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		return false;
				}
	}

	@Transactional
	public boolean deleteProduct(int id) {
		Session ss=sessionFactory.getCurrentSession();
		ss.delete(getProductId(id));
		return false;
	}
	
	
}

