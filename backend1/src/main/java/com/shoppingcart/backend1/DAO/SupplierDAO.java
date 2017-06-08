package com.shoppingcart.backend1.DAO;

import java.util.List;

import com.shoppingcart.backend1.model.Supplier;


public interface SupplierDAO
{

    boolean addSup(Supplier s);
	List<Supplier>getAllSupplier();

	public boolean update(Supplier s);
	public boolean deleteSup(String id);
	public Supplier getSupplierId(String id);
}
