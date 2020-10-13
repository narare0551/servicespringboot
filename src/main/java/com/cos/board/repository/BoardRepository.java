package com.cos.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.board.model.Board;

//auto IOC register
//because JPA repository includes the annotations like @Component etc
public interface BoardRepository extends JpaRepository<Board, Integer>{

}
