package com.board.photo.web.controller.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.photo.domain.user.CustUser;
import com.board.photo.service.custuser.CustUserService;
import com.board.photo.web.dto.CustUserReqDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class AuthContorller {
	
	private final CustUserService custUserService;
	
	@PostMapping("/auth/signup")
	@ResponseBody
	public Map<String, Object> signup(@RequestBody CustUserReqDto custUserReqDto) {
		
		Map<String, Object> result = new HashMap<>();
		
		CustUser custUser = custUserService.loadUserByUsername(custUserReqDto.getEmail());
		
		if(custUser != null) {
			result.put("result", "dup");
			return result;
		}
		
		try {
			custUserService.save(custUserReqDto);
		} catch (Exception e) {
			result.put("result", "err");
			return result;
		}
		
		if(log.isDebugEnabled()) {
			log.debug("custUserReqDto : " + custUserReqDto);
		}
		
		return result;
	}
}
