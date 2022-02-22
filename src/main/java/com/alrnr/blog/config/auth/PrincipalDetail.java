package com.alrnr.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alrnr.blog.model.User;


// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다. -> PrincipalDetail에 DB에 들어가는 값을 포함해, 다른 정보가 같이 저장됨
public class PrincipalDetail implements UserDetails{
	private User user; //콤포지션

	
	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() { //계정 안 만료?
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { //계정이 잠겨있지 않은가?
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호 안 만료?
		return true;
	}

	@Override
	public boolean isEnabled() { // 계정 사용가능해?(활성화)
		return true;
	}
	
	
	// 계정이 갖고있는 권한 목록을 리턴한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_" + user.getRole();});			//람다식 표현
		
		return collectors;
	}
	
}
