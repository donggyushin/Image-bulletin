package com.example.demo.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;

@Controller
@RequestMapping(value="/article")
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@GetMapping(value="")
	public String articleForm() {
		return "/article/form";
	}
	
	@PostMapping(value="/upload")
	public String uploadArticle(HttpServletRequest request, @RequestPart MultipartFile files) throws Exception {
		
		Article article = new Article();
		
		article.setContent(request.getParameter("content"));
		
		if(files.isEmpty()) {
			return "main";
		}else {
			String sourceFileName = files.getOriginalFilename();
			String sourceFileNameExtension = FilenameUtils.getExtension(sourceFileName).toLowerCase();
			File destinationFile; 
			String destinationFileName;
			String fileUrl = "/Users/jwajunhyeob/workspace-spring/SpringTest/src/main/webapp/WEB-INF/uploadFiles/";
			
			do {
				destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + sourceFileNameExtension;
				destinationFile = new File(fileUrl + destinationFileName);
			}while(destinationFile.exists());
			
			destinationFile.getParentFile().mkdirs();
			files.transferTo(destinationFile);
			
			article.setFileName(destinationFileName);
			article.setFileOriName(sourceFileName);
			article.setFileUrl(fileUrl);
			
			articleRepository.save(article);
		}
		
		
		
		
		return "main";
	}
	
}
