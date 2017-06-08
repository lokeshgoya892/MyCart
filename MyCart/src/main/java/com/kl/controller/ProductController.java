package com.kl.controller;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingcart.backend1.model.Product;
import com.shoppingcart.backend1.DAO.CategoryDAO;
import com.shoppingcart.backend1.DAO.ProductDAO;
import com.shoppingcart.backend1.DAO.SupplierDAO;

@Controller

public class ProductController {

	@Autowired
	HttpSession httpSession;

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	
	@RequestMapping("/adminProduct")
	public String pro(Model model) 
	{
		model.addAttribute("product",new Product());
		httpSession.setAttribute("supplierList",supplierDAO.getAllSupplier());
		httpSession.setAttribute("categoryList",categoryDAO.getAllCategory());
		model.addAttribute("productList", productDAO.getAllProduct());
		
		return "Product";

		
	}
	
	@RequestMapping("/allProducts/{catId}")
	public ModelAndView getProdByCat(@PathVariable("catId") String id,Model model){
		System.out.println("nhi ho rha");
		ModelAndView mv=new ModelAndView("/Beard");
	model.addAttribute("productList", productDAO.getProductByCategory(id));
	return mv;
	}
	
	
	
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public String Product(@ModelAttribute("product") Product p, Model model) {
		System.out.println("aashish dhudhiya");
System.out.println(p.getProductname());
System.out.println(p.getPrice());
		if (p.getProductId() == 0)
		{
			
			if (productDAO.addPro(p))
				{
				 
				productDAO.addPro(p);
				MultipartFile file=p.getImage();
			
				ServletContext con=httpSession.getServletContext();
				String filelocation=con.getRealPath("/resources/images/");
				System.out.println(filelocation);
				String filename=filelocation+"\\"+p.getProductId()+".jpg";
				System.out.println(filename);
				
				try{
					byte b[]=file.getBytes();
					FileOutputStream fos=new FileOutputStream(filename);
					fos.write(b);
					fos.close();
				}
				catch(IOException ex){} 
				catch(Exception e){
				}
				}
					else {
						model.addAttribute("msg", "Data not save in database");
						}
		}
			else {
			productDAO.updateProduct(p);
		}
		return "redirect:/adminProduct";
	}

	@RequestMapping("/updateProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model model)
	{
		model.addAttribute("product", productDAO.getProductId(productId));
		model.addAttribute("productList", productDAO.getAllProduct());
		return "Product";// here it is jsp
    }
	
	
	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId, Model model) 
	{
		productDAO.deleteProduct(productId);
		return "redirect:/adminProduct";// here it is mapping
	}
	
}

 	