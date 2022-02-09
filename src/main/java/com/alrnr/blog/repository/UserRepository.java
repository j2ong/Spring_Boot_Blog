package com.alrnr.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alrnr.blog.model.User;

// DAO
// 자동으로 bean 등록이 되서, Repository 어노테이션 생략 가능
// 쉽게말해, 자바와 데이터베이스를 연동하겠습니다~
public interface UserRepository extends JpaRepository<User, Integer>{ //User Table의 Primary key는 Integer형이다.
	
}

	//전통적인 방식 : JPA Naming 전략
	// Select * from user WHERE username =? AND Password = ?;                 이렇게 동작한다. 원래 findByid 이렇게 하나의 형태인데, And를 통해 2개 한거같음
	// User findByUsernameAndPassword(String username, String password);
	
	//위와 같이 동작하는 네이티브 쿼리형식
	//@Query(value = "Select * from user WHERE username =?1 AND Password = ?2",nativeQuery=true)
	//User login(String username, String password);