package com.alrnr.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
