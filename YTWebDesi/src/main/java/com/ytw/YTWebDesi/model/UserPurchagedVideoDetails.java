package com.ytw.YTWebDesi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserPurchagedVideoDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "videoPurchagedId", nullable = false, unique = true)
	private int videoPurchagedId;
	
	@Column(name = "userId", nullable=false, unique=false)
	private String userId;
	
	@Column(name = "videoId", nullable = false, unique = false)
	private int videoId;
	
	@Column(name = "videoPurchagedDateTime", nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date videoPurchagedDateTime;

	public UserPurchagedVideoDetails() {
		super();
	}

	public UserPurchagedVideoDetails(int videoPurchagedId, String userId, int videoId, Date videoPurchagedDateTime) {
		super();
		this.videoPurchagedId = videoPurchagedId;
		this.userId = userId;
		this.videoId = videoId;
		this.videoPurchagedDateTime = videoPurchagedDateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public Date getVideoPurchagedDateTime() {
		return videoPurchagedDateTime;
	}

	public void setVideoPurchagedDateTime(Date videoPurchagedDateTime) {
		this.videoPurchagedDateTime = videoPurchagedDateTime;
	}

	public int getVideoPurchagedId() {
		return videoPurchagedId;
	}

	public void setVideoPurchagedId(int videoPurchagedId) {
		this.videoPurchagedId = videoPurchagedId;
	}

	@Override
	public String toString() {
		return "UserPurchagedVideoDetails [videoPurchagedId=" + videoPurchagedId + ", userId=" + userId + ", videoId="
				+ videoId + ", videoPurchagedDateTime=" + videoPurchagedDateTime + "]";
	}

}


