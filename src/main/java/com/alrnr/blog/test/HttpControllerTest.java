package com.alrnr.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML파일)
// @Controller

// 인터넷 브라우저 요청은 Get 요청밖에 할 수 없다.
// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
	
	@GetMapping("/http/get")
	public String getTest() {
		return "Get 요청";
	}
	
	@PostMapping("/http/Post")
	public String postTest() {
		return "Post 요청";
	}
	
	@PutMapping("/http/Put")
	public String putTest() {
		return "Put 요청";
	}
	
	@DeleteMapping("/http/Delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
