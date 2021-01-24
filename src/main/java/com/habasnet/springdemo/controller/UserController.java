package com.habasnet.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.habasnet.springdemo.model.User;
import com.habasnet.springdemo.repository.UserRepository;


@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

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


		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		if(userRepository.userLogin(user.getUserName(), user.getPassword()) != null) {

			model.addAttribute("username", user.getUserName());
			return "home";
		}

		model.addAttribute("message", "User not found!!");
		return "loginForm";
	}

	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String userSignup(@ModelAttribute User user) {

		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userRepository.save(user);
		return "redirect:/login";
	}
}
