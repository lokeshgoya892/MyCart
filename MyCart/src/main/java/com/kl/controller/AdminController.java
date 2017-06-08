package com.kl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	@RequestMapping("/Adminindex")
	public ModelAndView showAdminindex()
	{
		ModelAndView mv = new ModelAndView("/Admin/Adminindex");
		return mv;
	}
	
	
	
}
