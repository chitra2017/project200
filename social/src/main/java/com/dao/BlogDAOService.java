package com.dao;

import java.util.Date;
import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.*;
import com.dao.Forum.ForumDAOImpl;
import com.model.*;

@Service     
@Transactional

public class BlogDAOService  {
	
	
	@Autowired
	private BlogDAOImpl bimpl;
	

	public boolean createBlog(Blog blog) {
	return bimpl.createBlog(blog);	}

	

	public Blog getBlogById(long blogID) {
		
		return bimpl.getBlogById(blogID);
	}

	public List<Blog> getAllBlogs() {
		
		return bimpl.getAllBlogs();
	}
	
	public List<Blog> getBlogsOfUser(String userID){
		return bimpl.getBlogsOfUser(userID);
	}

}
