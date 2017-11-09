package com.dao.user;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.model.*;
@Service     
@Transactional
public class UserDAOService{
	@Autowired
	private UserDAOImpl up;
	

	public boolean createUser(User user) {
		return up.createUser(user);
	}

	public boolean updateUser(User user) {
		return up.updateUser(user);
	}

	public User getUserById(String userID) {
		return up.getUserById(userID);
	}

	

	public List<Friend> getAllFriendsOfUser(String userID) {
		return up.getAllFriendsOfUser(userID);
	}
	
	public List<Friend> getFriendsOfUser(String userID){
		return up.getFriendsOfUser(userID);
	}

	public List<Friend> getFriendsReqOfUser(String userID){
		return up.getFriendsReqOfUser(userID);
	}

	public boolean userValidate(String userID,String password) {
		return up.userValidate(userID,password);
	}



	public boolean sendFriendRequest(String senderID, String receiverId) {
		return up.sendFriendRequest(senderID, receiverId);
	}

	public boolean acceptFriendRequest(String receiverId, String senderID) {
		return up.acceptFriendRequest(receiverId, senderID);	}

	public boolean rejectRequest(String senderId, String receiverID) {
		return up.rejectRequest(senderId, receiverID);	
	}

	public boolean setUserOffline(String userID) {
		return up.setUserOffline(userID);
	}

	public List<User> getAllUsers(String uid) {
		// TODO Auto-generated method stub
		return up.getAllUsers(uid);
	}

	
	
}