package com.hello.jpa.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hello.jpa.exception.ArticleException;
import com.hello.jpa.model.Article;
import com.hello.jpa.model.ArticleIdTime;
import com.hello.jpa.model.ArticleResponse;
import com.hello.jpa.model.TimeToRead;
import com.hello.jpa.model.UserTo;
import com.hello.jpa.service.ArticleService;

@RestController
@RequestMapping("/api")
public class ArticleController {

	@Autowired
	ArticleService userService;

	@PostMapping("/users/{slug}")
	public ArticleResponse createUser(@PathVariable String slug, @RequestBody UserTo us) {

		return userService.create(slug, us);
	}

	@PutMapping("/update/{slug}")
	public ArticleResponse updateUser(@PathVariable String slug, @RequestBody UserTo us) {
		return userService.updateArticle(slug, us);

	}

	@GetMapping("/userget/{slug}")
	public Article getUser(@PathVariable String slug) throws ArticleException {
		Article us = userService.getUserDetail(slug);
		if (null == us) {
			throw new ArticleException("Article not found");
		}
		return us;
	}

	@DeleteMapping("/article/{slug}")
	public boolean deleteUser(@PathVariable String slug) {
		return userService.deleteArticle(slug);
	}

	@GetMapping("/gettimedetail/{slug}")
	public ArticleIdTime getTimeDetail(@PathVariable String slug) {
		TimeToRead ts = new TimeToRead();
		ArticleIdTime ait = new ArticleIdTime();
		long starttime = System.currentTimeMillis();
		ArticleIdTime us = userService.getTimeDetail(slug);
		if (null == us) {
			throw new ArticleException("Article not found");
		}

		long endtime = System.currentTimeMillis();
		long diff = endtime - starttime;

		long timesec = diff / 60;
		long min = timesec / 60;
		long sec = timesec % 60;
		ait.setArticleId(slug);
		ts.setMin(min);
		ts.setSec(sec);
		ait.setTimeToRead(ts);
		return ait;

	}

}
