package com.dao.user;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.model.*;

@Repository
public class UserDAOImpl implements UserDAO {
	
	//private static final Logger log=LoggerFactory.getLogger(UserDAOImpl.class);
	
	private SessionFactory sessionFactory;
	
	UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public boolean createUser(User user) {
		try{
			user.setLastSeenOnline(new Date());
			user.setUserRole("ROLE_USER");
			user.setEnabled(1);
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e){
			System.err.println(e);
			return false;
		}
	}

	public boolean updateUser(User user) {
		try{
			String sql="select userID,friendId,friendStatus from user_friends where userid= '"+user.getUserID()+"'";
			List<Object> list=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
System.out.println("up"+list.size());





Friend f;
for(int i=0;i<list.size();i++){
	f=new Friend();
	Object[] obj=(Object[]) list.get(i);
	f.setUserID((String) obj[0]);
	f.setFriendId((String) obj[1]);
	f.setFriendStatus((String) obj[2]);
	f.setIsOnline('N');
	user.getUserFriends().add(f);
	
}
			
			user.setLastSeenOnline(new Date());
			user.setUserRole("ROLE_USER");
			user.setEnabled(1);
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e){
			System.err.println(e);
			return false;
		}
	}

	public User getUserById(String userID) {
		return  (User) sessionFactory.getCurrentSession().get(User.class, userID);
	}

	public List<User> getAllUsers(String uid) {
		String sql="select userID,userName from User where userID <> '"+uid+"' and userid not in(select friendid from user_friends where userID='"+uid+"')";
		 
		List<Object> list=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		
		List<User> returnList=new ArrayList<User>();
		User usr;
		for(int i=0;i<list.size();i++){
			usr=new User();
			Object[] obj=(Object[]) list.get(i);
			usr.setUserID((String) obj[0]);
			usr.setUserName((String) obj[1]);
			
			returnList.add(usr);
			
		}
		System.out.println(""+returnList.size());	
		return returnList;
		
		
		//return sessionFactory.getCurrentSession().createQuery("from User where userID<>"+uid).list();
	}

	public List<Friend> getAllFriendsOfUser(String userID) {
		User user=(User) getUserById(userID);
		return user.getUserFriends();
	}
	
	public List<Friend> getFriendsOfUser(String userID){
		System.out.println("impl meth"+userID);
		String sql="select userID,friendId,friendStatus from USER_FRIENDS where USERID=:userID and FRIENDSTATUS='Friend'";
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("userID", userID);
		List<Object> queryList=query.list();
		List<Friend> returnList=new ArrayList<Friend>();
		Friend frd;
		for(int i=0;i<queryList.size();i++){
			frd=new Friend();
			Object[] obj=(Object[]) queryList.get(i);
			frd.setUserID((String) obj[0]);
			frd.setFriendId((String) obj[1]);
			frd.setFriendStatus((String)obj[2]);
			
				frd.setIsOnline('N' );
			returnList.add(frd);
		}
		System.out.println(""+returnList.size());
		return returnList;
	}

	public List<Friend> getFriendsReqOfUser(String userID){
		String sql="select userID,friendId,friendStatus from USER_FRIENDS where friendId=:userID and FRIENDSTATUS='Request Sent'";
		SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setParameter("userID", userID);
		List<Object> queryList=query.list();
		List<Friend> returnList=new ArrayList<Friend>();
		Friend frd;
		for(int i=0;i<queryList.size();i++){
			frd=new Friend();
			Object[] obj=(Object[]) queryList.get(i);
			frd.setUserID((String) obj[0]);
			frd.setFriendId((String) obj[1]);
			frd.setFriendStatus((String)obj[2]);
		
					frd.setIsOnline('N' );
			returnList.add(frd);
		}
	
		return returnList;
	}

	public boolean userValidate(String userID,String password) {
		String sql="select * from User where userID = '"+userID+"' and  userPassword='"+password+"'";
		List<Object> list=sessionFactory.getCurrentSession().createSQLQuery(sql).list();
		System.out.println(list.size());
			if(list.isEmpty()){
				System.out.println("no user");
					return false;
			}
			else{
				return true;
			}			
	}

	public boolean sendFriendRequest(String senderID, String receiverId)
	{
		try
		{ 
			System.out.println(senderID);
	
		User sendUser=(User) sessionFactory.getCurrentSession().load(User.class, new String( senderID));
		
			
			
		System.out.println( sendUser.getUserName());
		Friend friend=new Friend();
		friend.setFriendId(receiverId);
		friend.setFriendStatus("Request Sent");
		friend.setIsOnline('N');
		sendUser.getUserFriends().add(friend);
		
		System.out.println(friend.getFriendId());
		sessionFactory.getCurrentSession().update(sendUser);
	
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean acceptFriendRequest(String receiverId, String senderID) {
		try {
			String sql="delete from USER_FRIENDS where USERID=:receiverID and FRIENDID=:senderId";
			SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setParameter("senderId", senderID);
			query.setParameter("receiverID", receiverId);
			query.executeUpdate();
			sql="delete from USER_FRIENDS where USERID=:receiverID and FRIENDID=:senderId";
			 query=sessionFactory.getCurrentSession().createSQLQuery(sql);
			query.setParameter("senderId", receiverId);
			query.setParameter("receiverID", senderID);
			query.executeUpdate();
			User receiveUser=(User) sessionFactory.getCurrentSession().load(User.class, new String( receiverId));
		User sendUser=(User) sessionFactory.getCurrentSession().load(User.class, new String( senderID));
	
		Friend sfriend=new Friend();
		sfriend.setFriendId(senderID);
		sfriend.setIsOnline('N');
	
		sfriend.setFriendStatus("Friend");
		receiveUser.getUserFriends().add(sfriend);
		Friend rfriend=new Friend();
		rfriend.setFriendId(receiverId);
		rfriend.setIsOnline('N');
		rfriend.setFriendStatus("Friend");
		sendUser.getUserFriends().add(rfriend);
		
		/*updateUser(receiveUser);
		updateUser(sendUser);*/
		return true;
		}
		catch(Exception e)
		{
		
			return false;
		}

	}

	public boolean rejectRequest(String senderId, String receiverID) {
		try
		{System.out.println("hello");
			String sql="delete from USER_FRIENDS where userID='"+receiverID+"' and friendId='"+senderId+"'";
			SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery(sql);
		
			int i= query.executeUpdate();
			System.out.println(i);
		
		return true;
		}
		catch(Exception e){
		
			return false;
		}
	}
	
	


	public boolean setUserOffline(String userID) {
		try{
			User user=(User) sessionFactory.getCurrentSession().createQuery("from User where userID='"+userID+"'").uniqueResult();
			SQLQuery query=sessionFactory.getCurrentSession().createSQLQuery("update USER_FRIENDS set ISONLINE='N' where FRIENDID=:userID");
			query.setParameter("userID", user.getUserID());
			query.executeUpdate();
			user.setIsOnline('N');
			user.setLastSeenOnline(new Date());
		
			updateUser(user);
			return true;
			}
			catch(Exception e){
		
				return false;
			}
	}

	

}
