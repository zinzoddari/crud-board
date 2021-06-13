package com.board.photo.domain.user;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.board.photo.domain.BaseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "T_CUST_USER")
public class CustUser extends BaseEntity implements UserDetails {
	
	private static final long serialVersionUID = -1662436710842803996L;

	@Id
	@Column(name = "EMAIL", nullable = true)
	private String email;
	
	@Column(name = "NAME", nullable = true)
    private String name;
	
	@Column(name = "PWD", nullable = true)
    private String pwd;
	
	@Column(name = "AUTH", nullable = true)
	private String auth;
	
	@Column(name = "STATE", nullable = true)
	private String state;
	
	@Builder
    public CustUser(String email, String name, String pwd, String auth, String state) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.auth = auth;
        this.state = state;
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<GrantedAuthority> roles = new HashSet<>();
		for(String role : auth.split(",")) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
