package com.alrnr.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alrnr.blog.model.User;
import com.alrnr.blog.repository.UserRepository;

@Service
public class UserService {	

	@Autowired
	private UserRepository userRepository; //얘가 디비
	
	@Transactional //이 메소드 전체가 하나의 트랜잭션!
	public void 회원가입(User user) {
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true) //Select할때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성)
	public User 로그인(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());                        //save함수는 있지만, login함수는 없다. 따로 만들어줘야함
	}
}
