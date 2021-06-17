package com.board.photo.web.controller.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.photo.service.boarddet.BoardDetService;
import com.board.photo.service.boardmst.BoardMstService;
import com.board.photo.web.dto.BoardSaveReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BoardContorller {
	
	private final BoardMstService boardMstService;
	private final BoardDetService boardDetService;
	
	@PostMapping("/board/{menu}/{subject}")
	@ResponseBody
	public Map<String, Object> save(@RequestBody BoardSaveReqDto boardSaveReqDto) {
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("result", "success");
		
		boardMstService.save(boardSaveReqDto);
		
		if(log.isDebugEnabled()) {
			log.debug("boardSaveReqDto : " + boardSaveReqDto);
		}
		
		return result;
	}
}
