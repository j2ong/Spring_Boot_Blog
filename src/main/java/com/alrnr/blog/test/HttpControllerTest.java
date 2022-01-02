package com.alrnr.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML파일)
// @Controller

// 인터넷 브라우저 요청은 Get 요청밖에 할 수 없다.
// 사용자가 요청 -> 응답(Data)

// http://localhost:8000/blog/http/get
@RestController
public class HttpControllerTest {
							 				// Member m -> 한꺼번에 받을때 (m.getxx())
	@GetMapping("/http/get") 				//RequestParam xx -> 하나씩 받을때
	public String getTest(Member m) { 		//?뒤의 쿼리스트링을 컨트롤러가 Member에 넣어줌
		return "Get 요청" + m.getId() +","+m.getUserName()+","+m.getPassWord()+","+m.getEmail();
	}
												//Post요청은 쿼리스트링이 아니라 Body에 데이터를 넣는다.
	@PostMapping("/http/post")					//Member m 가능
	public String postTest(@RequestBody Member m) {		//RequestBody String text -> 키:값이 텍스트로 나옴	
		return "Post 요청 : 	" + m.getId() +","+m.getUserName()+","+m.getPassWord()+","+m.getEmail();
	}
		
	@PutMapping("/http/put")		
	public String putTest() {
		return "Put 요청";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
