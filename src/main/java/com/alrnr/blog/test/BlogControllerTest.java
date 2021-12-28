package com.alrnr.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring이 패키지 이하의 모든 파일을 메모리에 스캔하는 것이 아니라, 특정 어노테이션이 붙은 클래스 파일들을 New해서 (IOC) 스프링 컨테이너에 관리함.
@RestController
public class BlogControllerTest {

	@GetMapping("/test/hello")
	public String hello() {
		return "<h1>Hello Spring boot</h1>";
	}
}
