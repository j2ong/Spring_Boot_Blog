package com.alrnr.blog.model;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data									// Getter, Setter
@NoArgsConstructor						// 생성자
@AllArgsConstructor
@Builder								// 빌더 패턴	
@Entity									// 클래스가 MySql에 테이블 생성 , ORM->JAVA Object -> 테이블로 매핑
public class Reply { 					// 댓글 클래스

	@Id 								//primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; 									// 시퀀스, auto_increment
	
	@Column(nullable=false,length=200)
	private String Content; 							// 댓글 내용
	
	@ManyToOne 											// 하나의 게시글에는 여러 댓글이 달릴 수 있다.
	@JoinColumn(name="boardId")							// FK
	private Board board; 								// 어떤 글에다 댓글을 달 것인지? 를 위해서 필요함 , DB적 관점 
	
	@ManyToOne 											//하나의 유저는 여러 댓글을 달 수 있다.
	@JoinColumn(name="userId")
	private User user;
	
	@CreatedDate										// 시간 자동 입력, CreationTimestamp는 지원해주지 않아 대체함.
	private Timestamp CreateDate;
	
}
