package com.hello.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.jpa.model.Article;
import com.hello.jpa.model.ArticleIdTime;
import com.hello.jpa.model.ArticleResponse;
import com.hello.jpa.model.UserTo;
import com.hello.jpa.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository userRepository;

	public ArticleResponse create(String slug, UserTo userto) {

		Article user = new Article();
		user.setBody(userto.getBody());
		user.setTitle(userto.getTitle());
		user.setDescription(userto.getDescription());
		user.setSlug(slug);
		Article u2 = userRepository.save(user);

		ArticleResponse us1 = new ArticleResponse();

		System.out.println("inside service get id::" + u2.getId());
		us1.setId(u2.getId());
		us1.setSlug(u2.getSlug());
		us1.setBody(u2.getBody());
		us1.setTitle(u2.getTitle());
		us1.setDescription(u2.getDescription());
		us1.setCreated_at(u2.getCreatedDate());
		us1.setUpdated_at(u2.getUpdatedDate());
		return us1;

	}

	public Article getUserDetail(String slug) {
		Article user = new Article();
		ArticleResponse ur = new ArticleResponse();
		user = userRepository.findBySlug(slug);
		return user;

	}

	public boolean deleteArticle(String slug) {
		Article user = new Article();
		user = userRepository.findBySlug(slug);
		userRepository.delete(user);
		return true;
	}

	public ArticleResponse updateArticle(String slug, UserTo uto) {
		Article user = new Article();
		ArticleResponse us = new ArticleResponse();
		user = userRepository.findBySlug(slug);
		user.setSlug(uto.getTitle());
		user.setTitle("How to learn Spring Booot");
		Article updatedUser = userRepository.save(user);

		us.setId(updatedUser.getId());
		us.setSlug(updatedUser.getSlug());
		us.setTitle(updatedUser.getTitle());
		us.setBody(updatedUser.getBody());
		us.setDescription(updatedUser.getDescription());
		us.setCreated_at(updatedUser.getCreatedDate());
		us.setUpdated_at(updatedUser.getUpdatedDate());
		return us;

	}

	public ArticleIdTime getTimeDetail(String slug) {
		ArticleIdTime ait = new ArticleIdTime();
		Article article = userRepository.findBySlug(slug);
       	ait.setArticleId(slug);
		return ait;
	}

}
