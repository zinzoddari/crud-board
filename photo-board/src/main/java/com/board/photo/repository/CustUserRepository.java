package com.board.photo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.photo.domain.user.CustUser;

public interface CustUserRepository extends JpaRepository<CustUser, String> {
	
	Optional<CustUser> findByEmail(String email);
}
