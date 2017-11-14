
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
import com.model.Blog;
import com.model.Comment;
import com.model.ForumCom;



 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class ForumComDAOtest {
	
	
	@Autowired
	 ForumComDAOService fcs;
	
	@Test
	public void getAllCommentsforum() {
		
		List<ForumCom> cflist=fcs.getAllComments(35);
		 assertNotNull("AllComments",cflist);
	}

	
	@Test
	public void addComment() {
		
		 assertNotNull("CreateComment",fcs.addComment(35, "chitra","average"));
		
	}

	

	@Test
	public void getComment(){
	
		 assertNotNull("GetComment",fcs.getComment(66));
	
	}

	
	
}
