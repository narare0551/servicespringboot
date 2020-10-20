package com.cos.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.board.model.Board;

// auto ioc registered.
public interface BoardRepository extends JpaRepository<Board, Integer>{
//public abstract hidden. 
	@Query(value="Select*from board where id =:id",nativeQuery = true)
	Board mFindById(int id);
	
	//int mDeleteById(int id);
	
}
