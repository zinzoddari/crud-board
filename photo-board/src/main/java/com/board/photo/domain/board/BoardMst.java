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
@Table(name = "T_BOARD_MST")
public class BoardMst extends BaseEntity {

	@Id
	@Column(name = "SVC_REQ_NO")
	private String svcReqNo;
	
	@Column(name = "MENU")
    private String menu;
	
	@Column(name = "BOARD_NO")
	private int boardNo;
	
	@Column(name = "WRITER")
    private String writer;
	
	@Column(name = "USE_YN")
	private String useYn;
	
	@Builder
    public BoardMst(String svcReqNo, String menu, int boardNo, String writer, String useYn) {
        this.svcReqNo = svcReqNo;
        this.menu = menu;
        this.boardNo = boardNo;
        this.writer = writer;
        this.useYn = useYn;
    }
}