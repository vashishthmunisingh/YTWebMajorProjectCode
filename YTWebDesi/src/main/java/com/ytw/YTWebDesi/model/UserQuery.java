package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserQuery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "queryId", nullable=false, unique=true)
	private int queryId;
	
	@Column(name = "userName", nullable=false, unique=false)
	private String userName;
	
	@Column(name = "userEmail", nullable=false, unique=false)
	private String userEmail;
	
	@Column(name = "mobileNumber", nullable=false, unique=false)
	private String mobileNumber;
	
	@Column(name = "country", nullable=false, unique=false)
	private String country;
	
	@Column(name = "subject", nullable=false, unique=false)
	private String subject;
	
	@Column(name = "userQueryDetails", nullable=false, unique=false)
	private String userQueryDetails;

	@Column(name = "createdDateTime", nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
	
	@Column(name = "lastUpdatedDateTime",nullable=true, unique=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;
	
	public UserQuery() {
		super();
	}

	public UserQuery(int queryId, String userName, String userEmail, String mobileNumber, String country,
			String subject, String userQueryDetails, Date createdDateTime, Date lastUpdatedDateTime) {
		super();
		this.queryId = queryId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.mobileNumber = mobileNumber;
		this.country = country;
		this.subject = subject;
		this.userQueryDetails = userQueryDetails;
		this.createdDateTime = createdDateTime;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserQueryDetails() {
		return userQueryDetails;
	}

	public void setUserQueryDetails(String userQueryDetails) {
		this.userQueryDetails = userQueryDetails;
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
		return "UserQuery [queryId=" + queryId + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", mobileNumber=" + mobileNumber + ", country=" + country + ", subject=" + subject
				+ ", userQueryDetails=" + userQueryDetails + ", createdDateTime=" + createdDateTime
				+ ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}
	
}


