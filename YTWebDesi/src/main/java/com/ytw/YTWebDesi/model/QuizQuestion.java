package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class QuizQuestion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "questionId", nullable=false, unique=true)
	private int questionId;
	
	@Column(name = "courseId", nullable=false, unique=false)
	private int courseId;
	
	@Column(name = "question", nullable=false, unique=false)
	private String question;
	
	@Column(name = "optionA", nullable=false, unique=false)
	private String optionA;
	@Column(name = "optionB", nullable=false, unique=false)
	private String optionB;
	@Column(name = "optionC", nullable=false, unique=false)
	private String optionC;
	@Column(name = "optionD", nullable=false, unique=false)
	private String optionD;
	
	@Column(name = "correctOption", nullable=false, unique=false)
	private String correctOption;
	
	@Column(name = "questionimg", nullable=false, unique=false)
	private String questionimg;
	
	@Column(name = "createdDateTime", nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
    
	@Column(name = "lastUpdatedDateTime", nullable=true, unique=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;

	public QuizQuestion() {
		super();
	}

	public QuizQuestion(int questionId, int courseId, String question, String optionA, String optionB, String optionC,
			String optionD, String correctOption, String questionimg, Date createdDateTime, Date lastUpdatedDateTime) {
		super();
		this.questionId = questionId;
		this.courseId = courseId;
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.correctOption = correctOption;
		this.questionimg = questionimg;
		this.createdDateTime = createdDateTime;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public String getQuestionimg() {
		return questionimg;
	}

	public void setQuestionimg(String questionimg) {
		this.questionimg = questionimg;
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
		return "QuizQuestion [questionId=" + questionId + ", courseId=" + courseId + ", question=" + question
				+ ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD
				+ ", correctOption=" + correctOption + ", questionimg=" + questionimg + ", createdDateTime="
				+ createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}
	
}



