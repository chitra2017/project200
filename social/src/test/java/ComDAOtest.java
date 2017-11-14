

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
import com.model.Blog;
import com.model.Comment;
import com.model.Friend;



 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class ComDAOtest {

	@Autowired
	 ComDAOService cs;

	@Test
	public void getAllCommentsblog() {
		
		List<Comment> cblist=cs.getAllComments(1);
		assertNotNull("All Blog Comments",cblist);
		
		for(Comment str:cblist)
		{
			System.out.println(str.getCommentID());
			
		}
	}
	@Test
	public void getAllComments(){
		
		List<Comment> clist=cs.getAllComments();
		assertNotNull("All Comments",clist);
		
	}
	@Test
	public void addComment() {
		
		assertNotNull("create Comment",cs.addComment(1, "viji","average"));
		
	}

	
	@Test
	public void getComment(){
		
		assertNotNull("Get Comment",cs.getComment(67));
	
	}


	
}
