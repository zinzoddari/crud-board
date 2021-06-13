package com.board.photo.service.custuser;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.photo.domain.user.CustUser;
import com.board.photo.repository.CustUserRepository;
import com.board.photo.web.dto.CustUserReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustUserService implements UserDetailsService {
	
	private final CustUserRepository custUserRepository;
	
	public String save(CustUserReqDto custUserDto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		custUserDto.setPwd(encoder.encode(custUserDto.getPwd()));
		
		CustUser custUser = CustUser.builder()
				.email(custUserDto.getEmail())
				.name(custUserDto.getName())
				.pwd(custUserDto.getPwd())
				.auth("U")
				.state("A").build();
		
		return custUserRepository.save(custUser).getEmail();
	}

	@Override
	public CustUser loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return custUserRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(email));
	}
}
