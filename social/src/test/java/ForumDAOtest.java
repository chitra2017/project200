
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.Test;
import org.junit.Ignore;
import java.util.Date;
import java.util.List;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.ComDAOService;
import com.dao.Forum.ForumComDAOService;
import com.dao.Forum.ForumDAOService;
import com.model.Blog;
import com.model.Comment;
import com.model.Forum;
import com.model.ForumCom;
import com.model.Friend;
import com.model.Members;



 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class ForumDAOtest{

	@Autowired
	ForumDAOService fs;
	

@Test
	public void createForumtest(){
	
	String s="naren";
  
   assertNotNull("Create Forum",fs.createForum("Angular", "AngularJS",s,"chitra"));
  
}
	
	


@Test
	public void getForumbyidtest(){
		
	 assertNotNull("Get By ID Forum",fs.getForumById(35));
		
		
	}
	@Test
	public void getAllForumtest(){
		
		List<Forum> flist=fs.getAllForum("chitra");
		 assertNotNull("AllForum",flist);
		 
		
	}
	@Test
	
	public void getMembers(){
		
		
		List<Members> mlist=fs.getMembers(35);
		 assertNotNull("Members",mlist);
		
	}
	
	

}