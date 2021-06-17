package com.board.photo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.photo.domain.board.BoardMst;

public interface BoardMstRepository extends JpaRepository<BoardMst, String> {
	
	List<BoardMst> findBySvcReqNoAndMenu(String svcReqNo, String menu);
	BoardMst findByMenuDesc(String menu);
}
