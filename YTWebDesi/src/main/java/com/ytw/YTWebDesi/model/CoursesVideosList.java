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
@Table(name = "CoursesVideosList")
public class CoursesVideosList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "videoId",nullable=false, unique=true)
	private int videoId;
	
	@Column(name = "courseId",nullable=false, unique=false)
	private int courseId;
	
	@Column(name = "YtVideoId",nullable=false, unique=false)
	private String YtVideoId;
	
	@Column(name = "videoTitle",nullable=false, unique=false)
	private String videoTitle;
	
	@Column(name = "createdDateTime",nullable=true)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date createdDateTime;
    
	@Column(name = "lastUpdatedDateTime",nullable=true)
    @DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date lastUpdatedDateTime;
	
	@Column(name = "isPaid",nullable=false)
    private String isPaid;
	
	@Column(name = "videoFee",nullable=false)
    private int videoFee;

	public CoursesVideosList() {
		super();
	}

	public CoursesVideosList(int courseId, int videoId, String ytVideoId, String videoTitle, Date createdDateTime,
			Date lastUpdatedDateTime, String isPaid, int videoFee) {
		super();
		this.courseId = courseId;
		this.videoId = videoId;
		YtVideoId = ytVideoId;
		this.videoTitle = videoTitle;
		this.createdDateTime = createdDateTime;
		this.lastUpdatedDateTime = lastUpdatedDateTime;
		this.isPaid = isPaid;
		this.videoFee = videoFee;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getYtVideoId() {
		return YtVideoId;
	}

	public void setYtVideoId(String ytVideoId) {
		YtVideoId = ytVideoId;
	}

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
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

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public int getVideoFee() {
		return videoFee;
	}

	public void setVideoFee(int videoFee) {
		this.videoFee = videoFee;
	}

	@Override
	public String toString() {
		return "CoursesVideosList [courseId=" + courseId + ", videoId=" + videoId + ", YtVideoId=" + YtVideoId
				+ ", videoTitle=" + videoTitle + ", createdDateTime=" + createdDateTime + ", lastUpdatedDateTime="
				+ lastUpdatedDateTime + ", isPaid=" + isPaid + ", videoFee=" + videoFee + "]";
	}
	
}
