package com.kl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcart.backend1.DAO.CategoryDAO;
import com.shoppingcart.backend1.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping("/Category")
	public String Cat(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList",categoryDAO.getAllCategory());
		
		return "Category";
	}	
	
	
	@RequestMapping("/addCat")
	public String category (@ModelAttribute("category") Category c, Model model)
	{
		if(c.getCatId()==null || c.getCatId().isEmpty())
		{
			if(categoryDAO.addCat(c))
				{
					model.addAttribute("message", "The Data Save in Database");
				}
			else
				{
					model.addAttribute("message","not correct");
				}
		}
		else
		{
          categoryDAO.update(c);
		}
	return "redirect:/Category";
	}

		
	@RequestMapping("/updateCategory/{catId}")
	public String editCategory(@PathVariable("catId") String catId, Model model)
	{
		model.addAttribute("category",categoryDAO.getCategoryId(catId));
		model.addAttribute("categoryList",categoryDAO.getAllCategory());
		return "Category"; // here category is jsp page
				
	}
	
	@RequestMapping("/deleteCategory/{catId}")
	public String deleteCategory(@PathVariable("catId") String catId, Model model)
	{
		categoryDAO.deleteCat(catId);
		return "redirect:/Category"; // here category is mapping
	}
	
	

	
	
	
	
}
