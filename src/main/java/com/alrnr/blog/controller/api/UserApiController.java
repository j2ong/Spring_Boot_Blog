package com.alrnr.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alrnr.blog.dto.ResponseDto;
import com.alrnr.blog.model.RoleType;
import com.alrnr.blog.model.User;
import com.alrnr.blog.service.UserService;

@RestController
public class UserApiController {

		@Autowired
		private UserService userService;
		
	
		@PostMapping("/api/user")
		public ResponseDto<Integer> save(@RequestBody User user) {
			System.out.println("가입완료");
			user.setRole(RoleType.USER);
			userService.회원가입(user);
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1); //자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
		}
		
		/*@PostMapping("/api/user/login")
		public  ResponseDto<Integer> login(@RequestBody User user, HttpSession session) { // 매개변수로 , HttpSession session 넣어줘도 DI한것과 같음
			System.out.println("로그인 완료");	
			User principal = userService.로그인(user); //principal(접근주체) 
			
			if(principal != null) { // 접근주체가 null이 아니면 = 진짜 있는 놈이면
				session.setAttribute("principal", principal);  //로그인 세션을 유지한다는 뜻
			}
			
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		}*/
		
		
}
