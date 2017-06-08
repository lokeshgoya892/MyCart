package com.shoppingcart.backend1.DAO;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.backend1.model.Author;
import com.shoppingcart.backend1.model.User;


	@Repository("userDAO")
	@Transactional
	public class UserDAOImp implements UserDAO
	{
		

		@Autowired
		SessionFactory sessionFactory;	

		public boolean addUser(User u) 
		
		{

		  Session	session	=sessionFactory.getCurrentSession();

				Author auth=new Author();
				
			   try
				{
				   	u.setUserId(u.getUname());
				   	auth.setUname(u.getUserId());
					auth.setRole("ROLE_USER");
					u.setActive(1);
					session.persist(u);
					session.persist(auth);
				  
				   
					session.persist(u);
					return true;
				}
				catch (Exception e)
				{
					
			   e.printStackTrace();	
				return false;
			}
		}
		
		
		@SuppressWarnings("unchecked")
		public List<User> getAllUser() 
		{
			Session session=sessionFactory.getCurrentSession();
			Query qu=session.createQuery("from User");
			List<User> userList=(List<User>)qu.list();
			return userList;

		}

		
		
		public boolean updateUser(User u) 
		{
			Session session=sessionFactory.getCurrentSession();
			try
			{
				session.update(u);
				return true;
			}
			catch (Exception e) 
			{
			e.printStackTrace();
			return false;
			}
		}

		
		
		public boolean deleteUser(String id) 
		{
			Session ss=sessionFactory.getCurrentSession();
			ss.delete(getUserId(id));
			return true;
		}

		public User getUserId(String id) {
			Session ss=sessionFactory.getCurrentSession();
			return (User) ss.get(User.class, id);
		}





}

