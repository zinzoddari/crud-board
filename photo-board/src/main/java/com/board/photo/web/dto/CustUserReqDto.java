package com.board.photo.web.dto;

import com.board.photo.domain.user.CustUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustUserReqDto {
	private String email;
	private String name;
	private String pwd;
	
	public CustUser toEntity() {
		return CustUser.builder()
				.email(email)
				.name(name)
				.pwd(pwd)
				.build();
	}
}
