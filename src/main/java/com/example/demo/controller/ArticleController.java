package com.example.demo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Article;
import com.example.demo.domain.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserRepository;

@Controller
@RequestMapping(value="/article")
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value="")
	public String articleForm(Model model, HttpSession session) {
		
		String userId = session.getAttribute("sessionedUser").toString();
		
		User loginedUser = userRepository.findByUserId(userId);
		
		model.addAttribute("loginedUser", loginedUser);
		
		return "/article/form";
	}
	
	@PostMapping(value="/upload/{id}")
	public String uploadArticle(@PathVariable int id,HttpServletRequest request, @RequestPart MultipartFile files, Model model) throws Exception {
		
		Article article = new Article();
		
		User user = userRepository.findById((long)id).get();
		
		article.setContent(request.getParameter("content"));
		
		if(files.isEmpty()) {
			model.addAttribute("ErrorMessage", "you need to submit appropriate image file. we support JPEG, PNG, PSD, PDD, PDF, SVG");
			return "main";
		}else {
			String sourceFileName = files.getOriginalFilename();
			String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
			File destinationFile; 
			String destinationFileName;
			String fileUrl = "/Users/jwajunhyeob/workspace-spring/SpringTest/src/main/webapp/WEB-INF/uploadFiles/";
			
			String fileType = sourceFileName.substring(sourceFileName.lastIndexOf(".")+1, sourceFileName.length()).toUpperCase();
			
			System.out.println(fileType);
			
			if( !(fileType.equals("JPEG")||fileType.equals("JPG")||fileType.equals("PNG")||fileType.equals("PSD")||fileType.equals("PDD")  || 
					fileType.equals("PDF")  || fileType.equals("SVG")) ) {
				model.addAttribute("ErrorMessage", "you need to submit appropriate image file. we support JPEG, PNG, PSD, PDD, PDF, SVG");
				return "main";
			}
			
			
			
			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
				destinationFile = new File(fileUrl + destinationFileName);
			}while(destinationFile.exists());
			
			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);
			
			article.setFileName(destinationFileName);
			article.setFileOriName(sourceFileName);
			article.setFileUrl(fileUrl);
			article.setUser(user);
			
			
			articleRepository.save(article);
		}
		
		
		
		
		return "main";
	}
	
}
