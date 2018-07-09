package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		
		User createdUser = new User(userId, userName, password, email);

		userRepository.save(createdUser);
		return "redirect:/";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("userId") String userId, @RequestParam("userPassword") String userPassword, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		
		System.out.println(userId + userPassword);
		
		User accessUser = new User();
		
		accessUser = userRepository.findByUserId(userId);
		
		
		//해당 아이디의 유저가 없을
		if(accessUser == null) {
			System.out.println("해당 아이디의 유저가 없습니다. ");
			String ErrorMessage = "There is no Id you input";
			mav.addObject("ErrorMessage", ErrorMessage);
			mav.setViewName("main");
			return mav;
		}
		
		//비밀번호가 서로 다를때 
		String realPassword = accessUser.getPassword();
		if(!realPassword.equals(userPassword)) {
			String ErrorMessage = "Wrong password";
			mav.addObject("ErrorMessage", ErrorMessage);
			mav.setViewName("main");
			return mav;
		}
		
		//제대로 로그인 됬을때
		session.setAttribute("sessionedUser", accessUser.getUserId());
		
		
		
		return mav;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("sessionedUser");
		mav.setViewName("main");
		return mav;
	}

}
