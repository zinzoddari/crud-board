package com.board.photo.domain.board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.board.photo.domain.BaseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "T_BOARD_DET")
public class BoardDet extends BaseEntity {

	@Id
	@Column(name = "SVC_REQ_NO")
	private String svcReqNo;
	
	@Column(name = "MENU")
    private String menu;
	
	@Column(name = "WRITER")
    private String writer;
	
	@Column(name = "SUBJECT")
	private String subject;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "PLATFORM")
	private String platform;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Builder
    public BoardDet(String svcReqNo, String menu, String writer, String subject, String title, String platform, String content) {
        this.svcReqNo = svcReqNo;
        this.menu = menu;
        this.writer = writer;
        this.subject = subject;
        this.title = title;
        this.platform = platform;
        this.content = content;
    }
}