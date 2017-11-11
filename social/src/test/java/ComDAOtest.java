

import junit.framework.Assert;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.ComDAOService;
import com.model.Blog;
import com.model.Comment;



 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class ComDAOtest {

	@Autowired
	private ComDAOService cs;

	@Test
	public void getAllCommentsblog() {
		System.out.println("---------------All Comments for the Blog  Test Case--------- ");
		List<Comment> cblist=cs.getAllComments(1);
		System.out.println("There are"+cblist.size()+" Comments for blogid 1 ");
		
	}
	@Test
	public void getAllComments(){
		System.out.println("---------------All Comments Test Case--------- ");
		List<Comment> clist=cs.getAllComments();
		System.out.println("There are"+clist.size()+" Comments ");
		
	}
	@Test
	public void addComment() {
		System.out.println("---------------Add Comment to the Blog Test Case--------- ");
		cs.addComment(1, "viji","average");
		System.out.println("The Comment is added for the blogid 1 ");
	}

	
	@Test
	public void getComment(){
		System.out.println("---------------Get Comment by Id  Test Case--------- ");
		Comment c=cs.getComment(67);
	
		System.out.println("Comment:"+c.getCommentText());
	}


	
}
