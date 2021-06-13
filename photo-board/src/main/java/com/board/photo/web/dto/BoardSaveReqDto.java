package com.board.photo.web.dto;

import com.board.photo.domain.board.BoardDet;
import com.board.photo.domain.board.BoardMst;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardSaveReqDto {
	private String menu;
	private String writer;
	private String subject;
	private String platform;
	private String title;
	private String content;
	
	public BoardMst toBoardMstEntity() {
		return BoardMst.builder()
				.menu(menu)
				.writer(writer)
				.build();
	}
	
	public BoardDet toBoardDetEntity() {
		return BoardDet.builder()
				.menu(menu)
				.writer(writer)
				.subject(subject)
				.platform(platform)
				.title(title)
				.content(content)
				.build();
	}
}
