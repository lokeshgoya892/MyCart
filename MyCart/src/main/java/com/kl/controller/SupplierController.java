package com.kl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcart.backend1.DAO.SupplierDAO;

import com.shoppingcart.backend1.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/Supplier")
	public String Sup(Model model)
	{
		model.addAttribute("SupplierList",supplierDAO.getAllSupplier());
		model.addAttribute("supplier", new Supplier());
		return "Supplier";
	}
	@RequestMapping("/addsup")
	public String supplier (@ModelAttribute("supplier") Supplier s, Model model)
	{
		
	if(s.getSupId()==null || s.getSupId().isEmpty())
		{
		if(supplierDAO.addSup(s))
	{
			
		model.addAttribute("msg", "The Data Save in Database");
	}
		else
		{
		model.addAttribute("msg","not correct");
		}
		}
	else
		{
         supplierDAO.update(s);
		}
	return "redirect:/Supplier";
	}

		
	@RequestMapping("/updateSupplier/{supId}")
	public String editSupplier(@PathVariable("supId") String supplierId, Model model)
	{
		model.addAttribute("supplier",supplierDAO.getSupplierId(supplierId));
		model.addAttribute("SupplierList",supplierDAO.getAllSupplier());
		return "Supplier"; //here it will return jsp
				
	}
	
	@RequestMapping("/deleteSupplier/{supId}")
	public String deleteCSupplier(@PathVariable("supId") String supId, Model model)
	{
		supplierDAO.deleteSup(supId);
		return "redirect:/Supplier"; //here it is mapping
	}
}
	