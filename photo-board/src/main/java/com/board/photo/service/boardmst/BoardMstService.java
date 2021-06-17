package com.board.photo.service.boardmst;
import org.springframework.stereotype.Service;

import com.board.photo.domain.board.BoardMst;
import com.board.photo.repository.BoardMstRepository;
import com.board.photo.utils.CommonUtils;
import com.board.photo.web.dto.BoardSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardMstService {
	
	private final BoardMstRepository boardMstRepository;
	
	public String save(BoardSaveReqDto boardSaveReqDto) {
		
		BoardMst boardMst = BoardMst.builder()
				.svcReqNo(CommonUtils.getUniqueId())
				.menu(boardSaveReqDto.getMenu())
				.boardNo(getLastBoardNo(boardSaveReqDto.getMenu()) + 1)
				.writer(boardSaveReqDto.getWriter())
				.useYn("Y").build();
		
		return boardMstRepository.save(boardMst).getSvcReqNo();
	}
	
	public int getLastBoardNo(String menu) {
		BoardMst boardMst = boardMstRepository.findByMenuDesc(menu);
		
		if(boardMst == null) {
			return 0;
		}

        return boardMst.getBoardNo();
    }
}