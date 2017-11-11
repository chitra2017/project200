package com.dao.user;

import java.util.List;

import com.model.*;

public interface UserDAO {
	
	public boolean createUser(User user);
	
	public boolean updateUser(User user);
	
	public User getUserById(String userID);
	
	public List<User> getAllUsers(String uid);
	
	public List<Friend> getAllFriendsOfUser(String userID);
	
	public List<Friend> getFriendsOfUser(String userID);
	
	public List<Friend> getFriendsReqOfUser(String userID);
	
	public boolean userValidate(String userID,String password);
	

	
	public boolean sendFriendRequest(String senderID,String receiverId);
	
	public boolean acceptFriendRequest(String receiverId,String senderID);
	
	public boolean rejectRequest(String senderId,String receiverID);
	

	
	
}
