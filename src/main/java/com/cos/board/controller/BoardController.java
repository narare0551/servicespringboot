package com.cos.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;

@Controller

public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	//http://localhost:8000/saveForm
	@GetMapping("/saveForm")
public String saveForm() {
		//saveForm is a file here because it is Controller, not RestController
	return "saveForm";
	
}
	
	@PostMapping("/save")
	public String save(BoardSaveRequestDto dto) {
		System.out.println(dto);
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
				boardRepository.save(boardEntity);
		return "list"; 
		
		
	}
	//Parameter in Controller Method in Spring get auto DI
	@GetMapping("/list")
	//model is registered in IUC as default
	//model carry the data to view 
	public String list(Model model) {
		List<Board> boards=boardRepository.findAll();
		model.addAttribute("boards",boards);
		return "list";
	}
	
	
}
