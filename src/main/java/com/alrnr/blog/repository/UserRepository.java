package com.alrnr.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alrnr.blog.model.User;

// DAO
// 자동으로 bean 등록이 되서, Repository 어노테이션 생략 가능
// 쉽게말해, 자바와 데이터베이스를 연동하겠습니다~
public interface UserRepository extends JpaRepository<User, Integer>{ //User Table의 Primary key는 Integer형이다.

}
