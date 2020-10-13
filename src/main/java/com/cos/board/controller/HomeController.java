package com.cos.board.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.board.model.Board;

@Controller // ViewResolver 관여 X
public class HomeController {
	
	
	@PostMapping("/home")
	@ResponseBody
	public String home() {	
		// src/main/webapp/WEB-INF/views/home.jsp
		System.out.println("hello");

		return "home";
	}
}
