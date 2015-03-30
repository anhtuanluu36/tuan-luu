package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("successmessage", "ABC successfully");
		return modelAndView;
	}

}
