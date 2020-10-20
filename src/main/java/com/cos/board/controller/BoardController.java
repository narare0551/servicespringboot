package com.cos.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.service.BoardService;

@Controller
public class BoardController {

	// 의존성 주입 DI
	@Autowired
	private BoardService boardService;

	// http://localhost:8000/saveForm
	@GetMapping("/saveForm")
	public String saveForm() {
		return "saveForm";
	}

	@PostMapping("/save")
	public String save(BoardSaveRequestDto dto) { // title=제목&content=내용
		boardService.WritePost(dto);	
		return "redirect:/list";
	}

	// 스프링에서 Controller의 메서드의 파라메터 부분은 자동 DI가 됨.
		@GetMapping({"", "/", "/list"})
		//Posts are usually descending (from 
		public String list(Model model, @PageableDefault(size=5, sort="id",direction=Direction.DESC) Pageable pageable) {
			model.addAttribute("boards", boardService.ViewList(pageable));
			return "list";
		}

		
		// TEST : show data instead of model because it is hard to see the model 
				@GetMapping({"", "/", "/list/test"})
				//Posts are usually descending (from 
				public String listTest( @PageableDefault(size=5, sort="id",direction=Direction.DESC) Pageable pageable) {
				
					return boardService.ViewList(pageable));
				}

		@GetMapping("/board/{id}")
		public String detail(@PathVariable int id, Model model) throws Exception {
			// Board board = boardRepository.findById(id).orElse(new Board());
			// Board board = boardRepository.findById(id).orElseGet(() -> new Board());
			model.addAttribute("board", boardService.DetailView
		(id));
			return "detail";
		}
		
		@DeleteMapping("/board/{id}")
		@ResponseBody
		public String delete(@PathVariable int id) {
			boardService.Delete(id);
			return "ok";
		}
		
		@PutMapping("/board/{id}")
		@ResponseBody
		public String update(@PathVariable int id, 
				@RequestBody BoardSaveRequestDto dto) {
			boardService.Update(id, dto);
			return "ok";
		}
	}