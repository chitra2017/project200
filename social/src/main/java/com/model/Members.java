package com.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Members  implements Serializable {
	
	@Transient
	private int ForumID;
	
	private String memberId;

	public int getForumID() {
		return ForumID;
	}

	public void setForumID(int forumID) {
		ForumID = forumID;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
		
	}
