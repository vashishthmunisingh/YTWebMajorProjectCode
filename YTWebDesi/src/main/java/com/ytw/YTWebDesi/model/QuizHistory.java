package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class QuizHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "quizHistoryId", nullable=false, unique=true)
	private int quizHistoryId;
	
	@Column(name = "userId", nullable=false, unique=false)
	private String userId;
	
	@Column(name = "totalQuestion", nullable=false, unique=false)
	private int totalQuestion;
	
	@Column(name = "correct", nullable=false, unique=false)
	private int correct;
	
	@Column(name = "wrong", nullable=false, unique=false)
	private int wrong;
	
	@Column(name = "notAnswered", nullable=false, unique=false)
	private int notAnswered;
	
	@Column(name = "createdDateTime", nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
    
	@Column(name = "lastUpdatedDateTime", nullable=true, unique=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;

	public QuizHistory() {
		super();
	}

	public QuizHistory(int quizHistoryId, String userId, int totalQuestion, int correct, int wrong, int notAnswered,
			Date createdDateTime, Date lastUpdatedDateTime) {
		super();
		this.quizHistoryId = quizHistoryId;
		this.userId = userId;
		this.totalQuestion = totalQuestion;
		this.correct = correct;
		this.wrong = wrong;
		this.notAnswered = notAnswered;
		this.createdDateTime = createdDateTime;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public int getQuizHistoryId() {
		return quizHistoryId;
	}

	public void setQuizHistoryId(int quizHistoryId) {
		this.quizHistoryId = quizHistoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getWrong() {
		return wrong;
	}

	public void setWrong(int wrong) {
		this.wrong = wrong;
	}

	public int getNotAnswered() {
		return notAnswered;
	}

	public void setNotAnswered(int notAnswered) {
		this.notAnswered = notAnswered;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Date getLastUpdatedDateTime() {
		return lastUpdatedDateTime;
	}

	public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	@Override
	public String toString() {
		return "QuizHistory [quizHistoryId=" + quizHistoryId + ", userId=" + userId + ", totalQuestion=" + totalQuestion
				+ ", correct=" + correct + ", wrong=" + wrong + ", notAnswered=" + notAnswered + ", createdDateTime="
				+ createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}
	
}

