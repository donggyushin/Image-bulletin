package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;

@Controller
@RequestMapping(value= "/article")
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	//article form 페이지
	@GetMapping(value="/form")
	public String articleForm() {
		return "/article/form";
	}
	
	
	//특정 article 조회 
	@GetMapping(value="/{id}")
	public String getArticle(Model model, @PathVariable int id) {
		
		Article article = articleRepository.findById(id).get();
		model.addAttribute("article", article);
		
		return "/article/detail";
	}
	
	//전체 article조회  
	@GetMapping(value="")
	public String getArticleList(Model model) {
		List<Article> articleList = articleRepository.findAll();
		model.addAttribute("articleList", articleList);
		return "/article/list";
	}
	
	//article 등록 
	@PostMapping(value="")
	public String setArticle(Article article) {
		article.setRegDate(new Date());
		
		System.out.println(article);
		
		articleRepository.save(article);
		
		return "redirect:/article/";
	}
	
	

}
