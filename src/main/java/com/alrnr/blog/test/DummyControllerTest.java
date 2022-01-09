package com.alrnr.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alrnr.blog.model.RoleType;
import com.alrnr.blog.model.User;
import com.alrnr.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired //의존성 주입(DI)
	private UserRepository userRepository; //연동한 놈을 여기서 쓰겠습니다~
				
	
																																	//Update
	@Transactional //save를 호출하지 않고 이놈을 사용
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id,  @RequestBody User requestUser) {
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정 실패");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		//userRepository.save(user); //디비와 연동된것은 userRepository임, 그래서 이놈을 조지면 디비에 연동
		return null;
	}
	
	
	
	
	
	
																												//Select
	
	// http://localhost:8000/blog/dummy/user/1
	@GetMapping("/dummy/user")                            //전체를 select
	public List<User> list(){
		return userRepository.findAll();
	}
	
	//페이지 단위로 불러옴,
	@GetMapping("/dummy/user/page")
	public Page<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> users= userRepository.findAll(pageable);
		return users;
	}
	
	
	// {id}주소로 파라미터를 전달 받을 수 있음
	// http://localhost:8000/blog/dummy/user/1
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id = "+id);
			}
		});
		// 요청 : 웹 브라우저
		// user 객체 : 자바 오브젝트
		// 변환 -> Json
		return user;
	}
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("username : "+user.getUsername());
		System.out.println("password : "+user.getPassword());
		System.out.println("email : "+user.getEmail());
		System.out.println("time : "+user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입 완료";		
	}
}
