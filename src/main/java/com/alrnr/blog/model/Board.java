package com.alrnr.blog.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//게시판

@Data									// Getter, Setter
@NoArgsConstructor						// 생성자
@AllArgsConstructor
@Builder								// 빌더 패턴	
@Entity									// 클래스가 MySql에 테이블 생성 , ORM->JAVA Object -> 테이블로 매핑
public class Board {					// 게시판 클래스
	@Id 												// primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; 									// 시퀀스, auto_increment
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob 												// 대용량 데이터
	private String Content; 							// 내용은 용량이 크다. html 코드도 포함한다.
	
	@ColumnDefault("0")
	private int count; 									// 조회수
	
	@ManyToOne(fetch = FetchType.EAGER) 				// Many == Board, One = User  , 하나의 작성자는 여러 게시글을 작성할 수 있다.
	@JoinColumn(name="userId") 							// FK
	private User user; 									// (User 클래스의 객체)
														
	
	@OneToMany(mappedBy = "board",fetch = FetchType.EAGER) // mappedBy -> 연관관계의 주인이 아니다.(난 FK가 아니에요) , DB에 컬럼을 만들지 말라. (원자성을 고려하여)
	private List<Reply> reply; 							// JPA를 통해 Borad를 Select하면 Reply와 user 모두 join해서 가져올 수 있도록 Board에 추가 , 댓글이 여러개라서 List다.
														// 하나의 게시글에는 여러 댓글이 달릴 수 있다. (주인 To 관계테이블)
	
	@CreationTimestamp									// 시간 자동 입력, CreationTimestamp는 지원해주지 않아 대체함.
	private Time createDate;
}
