package com.alrnr.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// Test용 클래스임 -> Member 테이블을 통해서 CRUD 테스트
// @Getter
// @Setter
@Data //getter+setter
@AllArgsConstructor //생성자
@NoArgsConstructor
public class Member {
	private int id;
	private String userName;
	private String passWord;
	private String email;

}	