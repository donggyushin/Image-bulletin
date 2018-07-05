package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/create")
	public String create(@RequestParam("userId") String userId, @RequestParam("userName") String userName, 
			@RequestParam("userPassword") String password, @RequestParam("userEmail") String email) {
		User newUser = new User();
		
		try {
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setUserId(userId);
			newUser.setUserName(userName);
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/SignUp";
		}
		
		userRepository.save(newUser);
		return "redirect:/";
	}

}
