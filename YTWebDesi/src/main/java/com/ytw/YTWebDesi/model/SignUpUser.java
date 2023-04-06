package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class SignUpUser {
	
	@Id
	@Column(name = "userName",nullable=false, unique=true)
	private String userName;
	
	@Column(name = "password",nullable=false, unique=false)
	private String password;
	
	@Column(name = "role",nullable=false, unique=false)
	private String role;

	@Column(name = "createdDateTime",nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
    
	@Column(name = "lastUpdatedDateTime",nullable=true, unique=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;
	
	public SignUpUser() {
		super();
	}

	public SignUpUser(String userName, String password, String role, Date createdDateTime, Date lastUpdatedDateTime) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.createdDateTime = createdDateTime;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
		return "SignUpUser [userName=" + userName + ", password=" + password + ", role=" + role + ", createdDateTime="
				+ createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}

}


