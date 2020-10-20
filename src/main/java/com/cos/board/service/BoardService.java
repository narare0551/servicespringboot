  package com.cos.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.board.dto.BoardSaveRequestDto;
import com.cos.board.model.Board;
import com.cos.board.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void WritePost(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}

	public List<Board> ViewList() {
		return boardRepository.findAll();
	}

	public Board DetailView(int id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Wrong Id Value "));
		return board;
	}

	@Transactional
	public void Delete(int id) {
		boardRepository.deleteById(id);
	}

	@Transactional
	public void Update(int id, BoardSaveRequestDto dto) {
		// Dirty Checking
		Board boardEntity = boardRepository.mFindById(id);
		boardEntity.setTitle(dto.getTitle());
		boardEntity.setContent(dto.getContent());
	}
}
