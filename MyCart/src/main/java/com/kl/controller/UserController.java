package com.kl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcart.backend1.DAO.UserDAO;
import com.shoppingcart.backend1.model.User;

@Controller
public class UserController {
	@Autowired
	UserDAO userDAO;
	
	
	@RequestMapping("/User")
	public String User(Model model)
	{
		model.addAttribute("user", new User());
		model.addAttribute("userList",userDAO.getAllUser());
		
		return "User";
	}	
	
	
	@RequestMapping("/addUser")
	public String user (@ModelAttribute("user") User u, Model model)
	{
		if(u.getUserId()==null || u.getUserId().isEmpty())
		{
			if(userDAO.addUser(u))
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
          userDAO.updateUser(u);
		}
	return "redirect:/User";
	}

		
	@RequestMapping("/updateUser/{userId}")
	public String editUser(@PathVariable("userId") String userId, Model model)
	{
		model.addAttribute("user",userDAO.getUserId(userId));
		model.addAttribute("userList",userDAO.getAllUser());
		return "User"; // here user is jsp page
				
	}
	
	@RequestMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") String userId, Model model)
	{
		userDAO.deleteUser(userId);
		return "redirect:/User"; // here user is mapping
	}
	
	
}
