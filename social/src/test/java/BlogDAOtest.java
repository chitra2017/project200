
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
import com.dao.BlogDAOService;
import com.model.Blog;
import com.model.Friend;

 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class BlogDAOtest  {
	
	
	@Autowired
	BlogDAOService bs;
	
@Test
	public void createBlogtest() {
		
	
		Blog b= new Blog();
		b.setBlogCreatorId("naren");
		b.setBlogData("JavaScript Framework");
		b.setBlogDescription("JS");
		b.setBlogName("JS");
assertTrue("Create",bs.createBlog(b));
}

	
@Test
	public void getBlogByIdtest() {
	
		assertNotNull("GetBlog", bs.getBlogById(1));
		
	}
@Test
	public void getAllBlogs() {
	
		List<Blog> blist=bs.getAllBlogs();
		assertNotNull("All Blogs",blist);
		
		for(Blog str:blist)
		{
			System.out.println(str.getBlogID());
			
		}
	}
@Test
	public void getBlogsOfUser(){
		
		List<Blog> bulist=bs.getBlogsOfUser("chitra");
assertNotNull("All Blogs of User",bulist);
		
		for(Blog str:bulist)
		{
			System.out.println(str.getBlogID());
			
		}
		
	}

}
