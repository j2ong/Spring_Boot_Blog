package com.alrnr.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping({"","/"}) //두 링크가 같다.
	public String index() {
		return "index"; // /WEB-INF/views/index.jsp
	}
}
