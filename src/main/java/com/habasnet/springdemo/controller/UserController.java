package com.habasnet.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.habasnet.springdemo.model.User;

import jdk.jfr.Frequency;

@Controller
public class UserController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginForm() {

		return "loginForm";
	}

	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String getSignupForm() {

		return "signupForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute User user, Model model) {
		
		if(user.getUserName().equals("ram") && user.getPassword().equals("helsinki")) {
			
			model.addAttribute("username", user.getUserName());
			return "home";
		}
		
		model.addAttribute("message", "User not found!!");
		return "loginForm";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String userSignup(@ModelAttribute User user) {
		
		return "redirect:/login";
	}
}
