package test.java;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.user.UserDAOService;
import com.model.User;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class UserDAOtest {

	

	

	@Autowired
	private UserDAOService us;
	
	@Test
	public void getUserFriendRequests(){
		User u=us.getUserById("chitra");
	
System.out.println("-----------------------Test Cases success-------------");
				System.out.println("User Name:"+u.getUserName());
				
				System.out.println("-----------------------Test Cases Ends-------------");
	}
	
}
