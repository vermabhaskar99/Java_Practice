package com.hello.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.jpa.model.Article;
import com.hello.jpa.model.ArticleResponse;
import com.hello.jpa.model.UserTo;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	Article findBySlug(String slug);
	
}
