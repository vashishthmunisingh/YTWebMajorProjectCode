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
@Table(name = "commentsReply")
public class CommentsReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "replyId",nullable=false, unique=true)
	private int replyId;
	
	@Column(name = "replyMadeOnCommentsCommentsId",nullable=false, unique=false)
	private int replyMadeOnCommentsCommentsId;
	
	@Column(name = "replyMadeByUserName",nullable=false, unique=false)
	private String replyMadeByUserName;
	@Column(name = "replyMadeByUserImage",nullable=true, unique=false)
	private String replyMadeByUserImage;
	
	@Column(name = "commentsReply",nullable=false, unique=false)
	private String commentsReply; 
	
	@Column(name = "repliedDateTime",nullable=true, unique=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy'T'HH:mm:ss.SSSZ")
    private Date repliedDateTime;

	public CommentsReply() {
		super();
	}

	public CommentsReply(int replyId, int replyMadeOnCommentsCommentsId, String replyMadeByUserName,
			String replyMadeByUserImage, String commentsReply, Date repliedDateTime) {
		super();
		this.replyId = replyId;
		this.replyMadeOnCommentsCommentsId = replyMadeOnCommentsCommentsId;
		this.replyMadeByUserName = replyMadeByUserName;
		this.replyMadeByUserImage = replyMadeByUserImage;
		this.commentsReply = commentsReply;
		this.repliedDateTime = repliedDateTime;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getReplyMadeOnCommentsCommentsId() {
		return replyMadeOnCommentsCommentsId;
	}

	public void setReplyMadeOnCommentsCommentsId(int replyMadeOnCommentsCommentsId) {
		this.replyMadeOnCommentsCommentsId = replyMadeOnCommentsCommentsId;
	}

	public String getReplyMadeByUserName() {
		return replyMadeByUserName;
	}

	public void setReplyMadeByUserName(String replyMadeByUserName) {
		this.replyMadeByUserName = replyMadeByUserName;
	}

	public String getReplyMadeByUserImage() {
		return replyMadeByUserImage;
	}

	public void setReplyMadeByUserImage(String replyMadeByUserImage) {
		this.replyMadeByUserImage = replyMadeByUserImage;
	}

	public String getCommentsReply() {
		return commentsReply;
	}

	public void setCommentsReply(String commentsReply) {
		this.commentsReply = commentsReply;
	}

	public Date getRepliedDateTime() {
		return repliedDateTime;
	}

	public void setRepliedDateTime(Date repliedDateTime) {
		this.repliedDateTime = repliedDateTime;
	}

	@Override
	public String toString() {
		return "CommentsReply [replyId=" + replyId + ", replyMadeOnCommentsCommentsId=" + replyMadeOnCommentsCommentsId
				+ ", replyMadeByUserName=" + replyMadeByUserName + ", replyMadeByUserImage=" + replyMadeByUserImage
				+ ", commentsReply=" + commentsReply + ", repliedDateTime=" + repliedDateTime + "]";
	}
	
}



