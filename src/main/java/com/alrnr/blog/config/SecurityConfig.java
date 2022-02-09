package com.alrnr.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리할 수 있게 하는 것

@Configuration
@EnableWebSecurity	// 시큐리티 필터 추가
//시큐리티는 모든 Request 요청이 컨트롤러에 가기전에 가로챈다. 그 전에 이 어노테이션이 동작해서, 아래 주소로 들어오면 허용하고 아닌 주소는 인증이 필요하도록 필터링 
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근하면 권한 및 인증을 미리 체크하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	//그러한 필터 설정을 하는 곳
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests()
				.antMatchers("/auth/**")		// /auth로 들어오는 모든 요청은
				.permitAll()								// permit 해주겠다.
				.anyRequest()						// 근데 다른 요청들은
				.authenticated()					// 권한이 필요하다.	
			.and()
				.formLogin()												// 인증이 필요한 요청이 들어오면
				.loginPage("/auth/loginForm");				// 이쪽가서 인증받아라. (기존 로그인 폼)
	}
}
