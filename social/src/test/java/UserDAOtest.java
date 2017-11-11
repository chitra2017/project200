
import junit.framework.Assert;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.user.UserDAOService;
import com.model.Friend;
import com.model.User;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class UserDAOtest {

	

	

	@Autowired
	private UserDAOService us;
	
	//@Test
	public void createUsertest() {
		System.out.println("----------------create user test case--------------");
		User user=new User();
		user.setUserID("dhetshi1");
		user.setUserName("Dhetsshanya");
		user.setUserPassword("1234");
		
		
		boolean f=us.createUser(user);
		if (f)
			System.out.println("User Created");
		else
			System.out.println("User not Created");
	}

	@Test
	public void updateUsertest() {
		System.out.println("----------------Update test case--------------");
		User user=us.getUserById("dhetshi1");
		user.setUserPassword("abc");
		
		boolean f= us.updateUser(user);
	
	if(f)
	System.out.println("user updated");
	else
		System.out.println("user not updated");	

	}

	
	
@Test
	public void getAllFriendsOfUsertest() {
	System.out.println("----------------All friends test case--------------");	
	List<Friend> allflist= us.getAllFriendsOfUser("chitra");
		Friend f=allflist.get(0);
		
		System.out.println(f.getFriendId());
		
	}

@Test
	public void getFriendsOfUsertest(){
	System.out.println("----------------Friends test case--------------");	
	List<Friend> flist= us.getFriendsOfUser("chitra");
		Friend f=flist.get(0);
		
		System.out.println(f.getFriendId());
	}



@Test
	public void sendFriendRequesttest() {
	System.out.println("----------------Request test case--------------");
	boolean	f=	us.sendFriendRequest("dhetshi1","saravanan"	);

if(f)
	System.out.println("Request Sent");
	}


@Test
	public void getFriendsReqOfUsertest(){
	System.out.println("----------------Friend Request  test case--------------");	
	List<Friend> rflist= us.getFriendsReqOfUser("saravanan");
		
		if (rflist.isEmpty())
			System.out.println("no user given req");
		else
		{	Friend f=rflist.get(0);
		System.out.println(f.getUserID());}
		}

@Test
public void acceptFriendRequesttest() {
	System.out.println("----------------accept Request  test case--------------");
	boolean	f=	us.acceptFriendRequest("dhetshi1","saravanan"	);

if(f)
	System.out.println("accepted Request");	
else
	
		System.out.println("no Request to accept");}


@Test
	public void userValidate() {
	System.out.println("----------------Validated test case--------------");	
	boolean f= us.userValidate("chitra","1234");
		
		if (f)
			System.out.println("validated");
		else
			System.out.println("not validated");
	}


@Test
	public void rejectRequesttest() {
	System.out.println("----------------Rejected Request  test case--------------");
	boolean	f=	us.rejectRequest("saravanan","naren"	);
	
	if(f)
		System.out.println("rejected Request");
	else
		System.out.println("no Request to reject");
	}



@Test
	public void getAllUserstest() {
	System.out.println("----------------All User  test case--------------");
		List<User> ulist= us.getAllUsers("chitra");
		User u=ulist.get(0);

		System.out.println(u.getUserName());
		
	}

@Test
	public void getuserbyid(){
	System.out.println("----------------Get userbyid  test case--------------");

	User u=us.getUserById("chitra");
	
	System.out.println("User Name:"+u.getUserName());
				

	}
	
}
