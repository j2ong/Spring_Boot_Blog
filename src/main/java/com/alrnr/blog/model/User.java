package com.alrnr.blog.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@DynamicInsert // insert할때 null 인 필드 제외

@Data									//Getter, Setter
@NoArgsConstructor						//생성자
@AllArgsConstructor
@Builder								//빌더 패턴
@EntityListeners(AuditingEntityListener.class)
@Entity			//클래스가 MySql에 테이블 생성 , ORM->JAVA Object -> 테이블로 매핑
public class User {
	
	@Id 												// primary key	
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; 									// 시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username; 							// 아이디
	
	@Column(nullable = false, length = 100) 			// password가 해쉬암호화 되어 길어질 것이기 때문에 넉넉하게 잡음
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//@ColumnDefault("'user'")
	@Enumerated(EnumType.STRING)
	private RoleType role; 								// 데이터의 도메인 , enum을 쓰는게 좋다 // admin,user	


	@CreatedDate
	private LocalDateTime createDate;					// 시간 자동 입력, CreationTimestamp는 지원해주지 않아 대체함.
}
