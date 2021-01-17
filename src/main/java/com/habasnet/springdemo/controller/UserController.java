package com.habasnet.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
