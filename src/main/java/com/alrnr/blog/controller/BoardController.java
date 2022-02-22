package com.alrnr.blog.controller;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.alrnr.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	@GetMapping({"","/"}) //두 링크가 같다.
	public String index(@AuthenticationPrincipal PrincipalDetail principal) { //로그인 후 일로오는데, 컨트롤러에서 세션을 어떻게 찾냐?
		System.out.println("아이디 : " + principal.getUsername());
		return "index"; // /WEB-INF/views/index.jsp
	}
}
