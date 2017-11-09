package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity

@Table(name="BLOG")
public class Blog  implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long blogID;
	
	
	private String blogName;
	
	
	private String blogCreatorId;
	
	private String blogData;
	
	private String blogDescription;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateDate;
	
	@OneToMany(mappedBy="blog",fetch = FetchType.EAGER)
	private Set<Comment> comments=new HashSet<Comment>();

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public long getBlogID() {
		return blogID;
	}

	public void setBlogID(long blogID) {
		this.blogID = blogID;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogCreatorId() {
		return blogCreatorId;
	}

	public void setBlogCreatorId(String blogCreatorId) {
		this.blogCreatorId = blogCreatorId;
	}

	public String getBlogData() {
		return blogData;
	}

	public void setBlogData(String blogData) {
		this.blogData = blogData;
	}

	public String getBlogDescription() {
		return blogDescription;
	}

	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
