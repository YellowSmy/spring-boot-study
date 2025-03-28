package com.example.sbb.answer;

import java.time.LocalDateTime;
import java.util.Set;

import com.example.sbb.question.Question;
import com.example.sbb.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter //일반적으로는 권장 X
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	private LocalDateTime modifyDate; //modify
	
	@ManyToOne
	private Question question;	
	
	//Creator
	@ManyToOne
	private SiteUser author;
	
	//Recommend
	@ManyToMany
	Set<SiteUser> voter;
}
