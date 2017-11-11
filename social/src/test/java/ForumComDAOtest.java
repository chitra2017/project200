

import junit.framework.Assert;

import java.util.Date;
import java.util.List;

import org.junit.Test;
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
	private ForumComDAOService fcs;
	
	@Test
	public void getAllCommentsforum() {
		System.out.println("---------------All Comments for the Forum  Test Case--------- ");
		List<ForumCom> cflist=fcs.getAllComments(35);
		System.out.println("There are "+cflist.size()+" Comments for Forumid 35");
		
	}

	
	@Test
	public void addComment() {
		System.out.println("---------------Add Comment to the Forum Test Case--------- ");
		fcs.addComment(35, "chitra","average");
		System.out.println("The Comment is added for the forum 35 ");
	}

	

	@Test
	public void getComment(){
		System.out.println("---------------Get Comment by Id  Test Case--------- ");
		ForumCom c=fcs.getComment(66);
	
		System.out.println("Comment:"+c.getCommentUserId());
	}

	
	
}
