
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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

@Table(name="USER")
public class User implements Serializable {
	
	@Id	
	 @NotEmpty(message="LoginID should not be Empty")
	private String userID;
	

	@NotEmpty(message="Name should not be Empty")
	private String userName;
	

	@NotEmpty(message="Password should not be Empty")
	private String userPassword;
	
	private char isOnline;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastSeenOnline;
	
	private String userRole;
	private int enabled;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="USER_FRIENDS",joinColumns=@JoinColumn(name="userID"))
	private List<Friend> userFriends=new LinkedList<Friend>();
	
	@Transient private MultipartFile image;
	public MultipartFile getImage() { return image; } public void setImage(MultipartFile image) { this.image = image; }

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public char getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}

	
	public Date getLastSeenOnline() {
		return lastSeenOnline;
	}

	public void setLastSeenOnline(Date lastSeenOnline) {
		this.lastSeenOnline = lastSeenOnline;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public List<Friend> getUserFriends() {
		return userFriends;
	}

	public void setUserFriends(List<Friend> userFriends) {
		this.userFriends = userFriends;
	}

	

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

}
