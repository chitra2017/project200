package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

@Table(name="ForumComment")
public class ForumCom  implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long commentID;
	
	private int forumID;
	
	private String commentUserId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date commentDate;
	
	private String commentText;
	
	
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="forumID", scope=Forum.class)
	@ManyToOne
	@JoinColumn(name = "forumID", nullable = false, updatable = false, insertable = false)
	private Forum f;
	
	public Forum getForum() {
		return f;
	}

	public void setForum(Forum f) {
		this.f=f;
	}
	public long getCommentID() {
		return commentID;
	}

	public void setCommentID(long commentID) {
		this.commentID = commentID;
	}

	

	public String getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(String commentUserId) {
		this.commentUserId = commentUserId;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public int getForumID() {
		return forumID;
	}

	public void setForumID(int forumID) {
		this.forumID = forumID;
	}

	}
