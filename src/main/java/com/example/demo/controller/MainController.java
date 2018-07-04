package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	

	@RequestMapping("/")
	public ModelAndView mainView() {
		ModelAndView mav = new ModelAndView("main");
		
		Map result = new HashMap();
		result.put("pageName", "main");
		
		mav.addObject("result", result);
		return mav;
	}

}
