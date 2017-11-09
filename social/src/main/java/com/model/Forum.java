
package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

@Table(name="Forum")
public class Forum implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumID;	
	private String forumName;	
	private String forumData;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateDate;	
	private String forumCreatorID;


	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Forum_Members",joinColumns=@JoinColumn(name="ForumID"))
	private List<Members> ForumMembers=new LinkedList<Members>();
	

	
	
	
public int getForumID() {
	return forumID;
}


public void setForumID(int forumID) {
	this.forumID = forumID;
}


public String getForumName() {
	return forumName;
}


public void setForumName(String forumName) {
	this.forumName = forumName;
}


public String getForumData() {
	return forumData;
}


public void setForumData(String forumData) {
	this.forumData = forumData;
}


public Date getLastUpdateDate() {
	return lastUpdateDate;
}


public void setLastUpdateDate(Date lastUpdateDate) {
	this.lastUpdateDate = lastUpdateDate;
}


public String getForumCreatorID() {
	return forumCreatorID;
}


public void setForumCreatorID(String forumCreatorID) {
	this.forumCreatorID = forumCreatorID;
}


public List<Members> getForumMembers() {
	return ForumMembers;
}


public void setForumMembers(List<Members> forumMembers) {
	ForumMembers = forumMembers;
}

		
}
