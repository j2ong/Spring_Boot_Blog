	package com.alrnr.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alrnr.blog.model.RoleType;
import com.alrnr.blog.model.User;
import com.alrnr.blog.repository.UserRepository;

@Service
public class UserService {	

	@Autowired
	private UserRepository userRepository; //얘가 디비
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional //이 메소드 전체가 하나의 트랜잭션!
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	
	
}
