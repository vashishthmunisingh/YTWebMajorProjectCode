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
@Table(name = "comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentsId",nullable=false, unique=true)
	private int commentsId;
	
	@Column(name = "commentsMadeByUserName",nullable=false, unique=false)
	private String commentsMadeByUserName;
	@Column(name = "commentsMadeByUserImage",nullable=true, unique=false)
	private String commentsMadeByUserImage;
	
	@Column(name = "commentsMadeOnCourseCourseId",nullable=false, unique=false)
	private int commentsMadeOnCourseCourseId;
	@Column(name = "commentsMadeOnVideoVideoId",nullable=false, unique=false)
	private int commentsMadeOnVideoVideoId;
	
	@Column(name = "comments",nullable=false, unique=false)
	private String comments; 
	
	@Column(name = "commentsMadeDateTime",nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date commentsMadeDateTime;

	public Comments() {
		super();
	}

	public Comments(int commentsId, String commentsMadeByUserName, String commentsMadeByUserImage,
			int commentsMadeOnCourseCourseId, int commentsMadeOnVideoVideoId, String comments,
			Date commentsMadeDateTime) {
		super();
		this.commentsId = commentsId;
		this.commentsMadeByUserName = commentsMadeByUserName;
		this.commentsMadeByUserImage = commentsMadeByUserImage;
		this.commentsMadeOnCourseCourseId = commentsMadeOnCourseCourseId;
		this.commentsMadeOnVideoVideoId = commentsMadeOnVideoVideoId;
		this.comments = comments;
		this.commentsMadeDateTime = commentsMadeDateTime;
	}

	public int getCommentsId() {
		return commentsId;
	}

	public void setCommentsId(int commentsId) {
		this.commentsId = commentsId;
	}

	public String getCommentsMadeByUserName() {
		return commentsMadeByUserName;
	}

	public void setCommentsMadeByUserName(String commentsMadeByUserName) {
		this.commentsMadeByUserName = commentsMadeByUserName;
	}

	public String getCommentsMadeByUserImage() {
		return commentsMadeByUserImage;
	}

	public void setCommentsMadeByUserImage(String commentsMadeByUserImage) {
		this.commentsMadeByUserImage = commentsMadeByUserImage;
	}

	public int getCommentsMadeOnCourseCourseId() {
		return commentsMadeOnCourseCourseId;
	}

	public void setCommentsMadeOnCourseCourseId(int commentsMadeOnCourseCourseId) {
		this.commentsMadeOnCourseCourseId = commentsMadeOnCourseCourseId;
	}

	public int getCommentsMadeOnVideoVideoId() {
		return commentsMadeOnVideoVideoId;
	}

	public void setCommentsMadeOnVideoVideoId(int commentsMadeOnVideoVideoId) {
		this.commentsMadeOnVideoVideoId = commentsMadeOnVideoVideoId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCommentsMadeDateTime() {
		return commentsMadeDateTime;
	}

	public void setCommentsMadeDateTime(Date commentsMadeDateTime) {
		this.commentsMadeDateTime = commentsMadeDateTime;
	}

	@Override
	public String toString() {
		return "Comments [commentsId=" + commentsId + ", commentsMadeByUserName=" + commentsMadeByUserName
				+ ", commentsMadeByUserImage=" + commentsMadeByUserImage + ", commentsMadeOnCourseCourseId="
				+ commentsMadeOnCourseCourseId + ", commentsMadeOnVideoVideoId=" + commentsMadeOnVideoVideoId
				+ ", comments=" + comments + ", commentsMadeDateTime=" + commentsMadeDateTime + "]";
	}
	
}






