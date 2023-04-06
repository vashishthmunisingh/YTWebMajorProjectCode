package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserProfile {
	
	@Id
	@Column(name = "userId",nullable=false, unique=true)
	private String userId; // email
	
	@Column(name = "country",nullable=true, unique=false)
	private String country;
	
	@Column(name = "state",nullable=true, unique=false)
	private String state;
	
	@Column(name = "city",nullable=true, unique=false)
	private String city;
	
	@Column(name = "pincode",nullable=true, unique=false)
	private int pincode;
	
	@Column(name = "completeAddress",nullable=true, unique=false)
	private String completeAddress;
	
	@Column(name = "image",nullable=true, unique=false)
	private String image;
	
	@Column(name = "createdDateTime",nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
    
	@Column(name = "lastUpdatedDateTime",nullable=true, unique=false)
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;

	public UserProfile() {
		super();
	}

	public UserProfile(String userId, String country, String state, String city, int pincode, String completeAddress,
			String image, Date createdDateTime, Date lastUpdatedDateTime) {
		super();
		this.userId = userId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.completeAddress = completeAddress;
		this.image = image;
		this.createdDateTime = createdDateTime;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
		return "UserProfile [userId=" + userId + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", pincode=" + pincode + ", completeAddress=" + completeAddress + ", image=" + image
				+ ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime=" + lastUpdatedDateTime + "]";
	}

}



