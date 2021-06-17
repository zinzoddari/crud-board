package com.board.photo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.photo.domain.board.BoardDet;

public interface BoardDetRepository extends JpaRepository<BoardDet, String> {
	
	List<BoardDet> findBySvcReqNoAndMenu(String svcReqNo, String menu);
}
