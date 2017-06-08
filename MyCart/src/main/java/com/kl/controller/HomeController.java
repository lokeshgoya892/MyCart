package com.kl.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shoppingcart.backend1.DAO.CategoryDAO;

@Controller
public class HomeController {
	@Autowired
	HttpSession session;

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","index"})
	public String goToindex()
	{
		session.setAttribute("categoryList",categoryDAO.getAllCategory());
		return "index";
	}
	@RequestMapping("/login")
	public String log(){
		return "login";
		
		
	}

}
