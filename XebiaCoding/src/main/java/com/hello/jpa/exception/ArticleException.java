package com.hello.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticleException extends RuntimeException {
	
	public ArticleException(String exception) {
		super(exception);
	}
	
	

}
