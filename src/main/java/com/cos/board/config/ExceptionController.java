package com.cos.board.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.board.config.ex.MyArgsNotFound;

@ControllerAdvice
@RestController
public class ExceptionController {
	
	@ExceptionHandler(value=Exception.class)
	public String allerror(Exception e) {
		return e.getMessage();
	}
}
