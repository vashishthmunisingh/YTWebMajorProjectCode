package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserPurchagedCourseDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coursePurchagedId", nullable = false, unique = true)
	private int coursePurchagedId;
	
	@Column(name = "userId", nullable = false, unique = false)
	private String userId;

	@Column(name = "courseId", nullable = false, unique = false)
	private int courseId;

	@Column(name = "purchagedDateTime", nullable = true, unique = false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
	private Date coursePurchagedDateTime;

	public UserPurchagedCourseDetails() {
		super();
	}

	public UserPurchagedCourseDetails(int coursePurchagedId, String userId, int courseId,
			Date coursePurchagedDateTime) {
		super();
		this.coursePurchagedId = coursePurchagedId;
		this.userId = userId;
		this.courseId = courseId;
		this.coursePurchagedDateTime = coursePurchagedDateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Date getCoursePurchagedDateTime() {
		return coursePurchagedDateTime;
	}

	public void setCoursePurchagedDateTime(Date coursePurchagedDateTime) {
		this.coursePurchagedDateTime = coursePurchagedDateTime;
	}

	public int getCoursePurchagedId() {
		return coursePurchagedId;
	}

	public void setCoursePurchagedId(int coursePurchagedId) {
		this.coursePurchagedId = coursePurchagedId;
	}

	@Override
	public String toString() {
		return "UserPurchagedCourseDetails [coursePurchagedId=" + coursePurchagedId + ", userId=" + userId
				+ ", courseId=" + courseId + ", coursePurchagedDateTime=" + coursePurchagedDateTime + "]";
	}

}


