

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
	private ForumDAOService fs;
	
@SuppressWarnings("null")
@Test
	public void createForumtest(){
	System.out.println("--------------- Forum Created Test Case--------- ");
	String s="naren";
   Forum f2= fs.createForum("Angular", "AngularJS",s,"chitra");
	System.out.println("------------------------ ");
  
}
	
	


@Test
	public void getForumbyidtest(){
		System.out.println("--------------- Forum by Id Test Case--------- ");
		Forum f=fs.getForumById(35);
		System.out.println("Forum Name"+ f.getForumName());
		
	}
	@Test
	public void getAllForumtest(){
		System.out.println("---------------All Forum Test Case--------- ");
		List<Forum> flist=fs.getAllForum("chitra");
		System.out.println("There are"+flist.size()+" Forums ");
		
	}
	@Test
	
	public void getMembers(){
		
		System.out.println("---------------Members of Forum Test Case--------- ");
		List<Members> mlist=fs.getMembers(35);
		System.out.println("There are"+mlist.size()+" Members ");
		
	}
	
	

}