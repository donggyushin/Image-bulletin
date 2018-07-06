package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/create")
	public String create(@RequestParam("userId") String userId, @RequestParam("userName") String userName, 
			@RequestParam("userPassword") String password, @RequestParam("userEmail") String email, Model model) {
		User newUser = new User();
		
		
		newUser = userRepository.findByEmailOrUserId(email, userId);
		
		if(newUser != null) {
			System.out.println("아이디 혹은 이메일이 중복됩니다.");
			String ErrorMessage = "Id or email is duplicated";
			model.addAttribute("ErrorMessage", ErrorMessage);
			return "main";
		}
		
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setUserId(userId);
		newUser.setUserName(userName);
		
		userRepository.save(newUser);
		return "redirect:/";
	}

}
