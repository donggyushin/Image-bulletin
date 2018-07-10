package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

}
