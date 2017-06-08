package com.shoppingcart.backend1.DAO;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shoppingcart.backend1.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImp implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;	

	public boolean addCat(Category c) 
	{
		   Session	session	=sessionFactory.getCurrentSession();
		   try
			{
			  
			   c.setCatId(c.getCname());
				session.persist(c);
				return true;
			}
			catch (Exception e)
			{
				
		   e.printStackTrace();	
			return false;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategory() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query qu=session.createQuery("from Category");
		List<Category> categoryList=(List<Category>)qu.list();
		return categoryList;

	}

	
	
	public boolean update(Category c) 
	{
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(c);
			return true;
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		return false;
		}
	}

	
	
	public boolean deleteCat(String id) 
	{
		Session ss=sessionFactory.getCurrentSession();
		ss.delete(getCategoryId(id));
		return true;
	}

	public Category getCategoryId(String id) {
		Session ss=sessionFactory.getCurrentSession();
		return (Category) ss.get(Category.class, id);
	}



}
