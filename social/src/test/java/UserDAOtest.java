

//import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;


import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import org.junit.Ignore;
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
	 UserDAOService us;
	@Ignore
	@Test
	public void createUsertest() {
		System.out.println("----------------create user test case--------------");
		User user=new User();
		user.setUserID("dhetshi170");
		user.setUserName("Dhetsshanya170");
		user.setUserPassword("1234");
	
		
		
		assertTrue("created the record",us.createUser(user));
			
		
	}

	@Test
	public void updateUsertest() {
		
		User user=us.getUserById("dhetshi170");
		user.setUserPassword("abc");
		
		
	assertTrue("updated the record",us.updateUser(user));
	}

	
	@Test
	public void getAllFriendsOfUsertest() {
		
	List<Friend> aflist= us.getAllFriendsOfUser("chitra");
	assertNotNull("All Friends",aflist);
	
	for(Friend str:aflist)
	{
		System.out.println(str.getFriendId());
		
	}
	}
	

@Test
	public void getFriendsOfUsertest(){
	
	List<Friend> flist= us.getFriendsOfUser("chitra");
	assertNotNull("Friends",flist);
	
	for(Friend str:flist)
	{
		System.out.println(str.getFriendId());
		
	}
	}



@Test
	public void sendFriendRequesttest() {
	
assertTrue("Sending Request",us.sendFriendRequest("dhetshi","chitra"));

	}


@Test
	public void getFriendsReqOfUsertest(){
		
	List<Friend> rflist= us.getFriendsReqOfUser("chitra");
	assertNotNull("Friends",rflist);
	
	for(Friend str:rflist)
	{
		System.out.println(str.getFriendId());
		
	}
}
@Test
public void acceptFriendRequesttest() {
	
	assertTrue("accept request",	us.acceptFriendRequest("dhetshi","chitra"	));

}


@Test
	public void userValidate() {
		
	assertTrue("userValidate",us.userValidate("chitra","1234"));
		
	
	}


@Test
	public void rejectRequesttest() {
	
	assertTrue("RejectRequest",	us.rejectRequest("naren","viji"	));
	
	}



@Test
	public void getAllUserstest() {
	
		List<User> ulist= us.getAllUsers("chitra");
		assertNotNull("Users",ulist);
		for(User str:ulist)
		{
			System.out.println(str.getUserID());
			
		}
		
	}

@Test
	public void getuserbyid(){
	

	User u=us.getUserById("chitra");
	assertNotNull("User",u);
				

	}
	
}
