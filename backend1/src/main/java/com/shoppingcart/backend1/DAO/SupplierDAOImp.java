package com.shoppingcart.backend1.DAO;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingcart.backend1.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImp implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;	
	public boolean addSup(Supplier s) 
	{
		   Session	session	=sessionFactory.getCurrentSession();
		   try
			{
			    s.setSupId(s.getSname());
				session.persist(s);
				return true;
			}
			catch (Exception e)
			{
				
		   e.printStackTrace();	
			return false;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Supplier> getAllSupplier() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query qu=session.createQuery("from Supplier");
		List<Supplier> Supplierlist=(List<Supplier>)qu.list();
		return Supplierlist;

	}

	
	
	public boolean update(Supplier s) 
	{
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(s);
			return true;
		}
		catch (Exception e) 
		{
		e.printStackTrace();
		return false;
		}
	}

	public boolean deleteSup(String id) 
	{
		Session ss=sessionFactory.getCurrentSession();
		ss.delete(getSupplierId(id));
		return true;
	}

	public Supplier getSupplierId(String id) {
		Session ss=sessionFactory.getCurrentSession();
		return (Supplier) ss.get(Supplier.class, id);
	}

}
