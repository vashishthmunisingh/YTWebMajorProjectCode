package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Coursedetail")
public class CourseDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "courseId",nullable=false, unique=true)
	private int courseId;
	
	@Column(name = "courseName",nullable=false)
	private String courseName;
	
	@Column(name = "courseDes",nullable=true)
	private String courseDes;
	
	@Column(name = "courseAuthor",nullable=false)
	private String courseAuthor;
	
	
	@Column(name = "createdDateTime",nullable=true)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
    
	@Column(name = "lastUpdatedDateTime",nullable=true)
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;
    
	@Column(name = "courseLogo",nullable=true)
    private String courseLogo;
    
	@Column(name = "isPaid",nullable=false)
    private String isPaid;
	
	@Column(name = "courseFee",nullable=false)
    private int courseFee;
    
	public CourseDetail() {
		super();
	}

	public CourseDetail(int courseId, String courseName, String courseDes, String courseAuthor, Date createdDateTime,
			Date lastUpdatedDateTime, String courseLogo, String isPaid, int courseFee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDes = courseDes;
		this.courseAuthor = courseAuthor;
		this.createdDateTime = createdDateTime;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
		this.courseLogo = courseLogo;
		this.isPaid = isPaid;
		this.courseFee = courseFee;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDes() {
		return courseDes;
	}

	public void setCourseDes(String courseDes) {
		this.courseDes = courseDes;
	}

	public String getCourseAuthor() {
		return courseAuthor;
	}

	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
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

	public String getCourseLogo() {
		return courseLogo;
	}

	public void setCourseLogo(String courseLogo) {
		this.courseLogo = courseLogo;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	@Override
	public String toString() {
		return "CourseDetail [courseId=" + courseId + ", courseName=" + courseName + ", courseDes=" + courseDes
				+ ", courseAuthor=" + courseAuthor + ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime="
				+ lastUpdatedDateTime + ", courseLogo=" + courseLogo + ", isPaid=" + isPaid + ", courseFee=" + courseFee
				+ "]";
	}
 
}
