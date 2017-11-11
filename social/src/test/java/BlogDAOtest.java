
import junit.framework.Assert;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.BlogDAOService;
import com.model.Blog;

 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/ApplicationContext.xml" })
public class BlogDAOtest  {
	
	
	@Autowired
	private BlogDAOService bs;
	
@Test
	public void createBlogtest() {
		
		System.out.println("---------------Create Blog Test Case--------- ");
		Blog b= new Blog();
		b.setBlogCreatorId("naren");
		b.setBlogData("JavaScript Framework");
		b.setBlogDescription("JS");
		b.setBlogName("JS");
		boolean f=	bs.createBlog(b);
		if(f)
			System.out.println("Blog Created");
		else
			System.out.println("Blog not Created");
		}

	
@Test
	public void getBlogByIdtest() {
		System.out.println("---------------Get Blog By Id Test Case--------- ");
		Blog b= bs.getBlogById(1);
		System.out.println(b.getBlogCreatorId());
	}
@Test
	public void getAllBlogs() {
		System.out.println("---------------All Blog Test Case--------- ");
		List<Blog> blist=bs.getAllBlogs();
		System.out.println("There are"+blist.size()+"blogs ");
	}
@Test
	public void getBlogsOfUser(){
		System.out.println("---------------Blogs created by user Test Case--------- ");
		List<Blog> bulist=bs.getBlogsOfUser("chitra");
		System.out.println("There are"+bulist.size()+"blogs for the user chitra ");
	}

}
