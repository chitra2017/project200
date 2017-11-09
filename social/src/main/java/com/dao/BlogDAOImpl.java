package com.dao;

import java.util.Date;
import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.dao.*;
import com.model.*;
import org.hibernate.SQLQuery;


public class BlogDAOImpl implements BlogDAO {
	
	
	
	private SessionFactory sessionFactory;
	
	BlogDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}


	public boolean createBlog(Blog blog) {
	
		try
		{
			blog.setLastUpdateDate(new Date());
			sessionFactory.getCurrentSession().save(blog);
			
		
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}

	}

	public boolean updateBlog(Blog blog) {
	
		try
		{
			blog.setLastUpdateDate(new Date());
			sessionFactory.getCurrentSession().update(blog);
			
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}

	}

	public boolean removeBlog(long blogId) {
		try
		{
		Blog blog=(Blog) getBlogById(blogId);
		
		

		for (Comment cmt : blog.getComments()){
			sessionFactory.getCurrentSession().delete(cmt);
		}
		 
		 sessionFactory.getCurrentSession().delete(blog);
		
			
		
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean removeBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
		
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public Blog getBlogById(long blogID) {
		
		return (Blog) sessionFactory.getCurrentSession().createQuery("from Blog where blogID='"+blogID+"'").uniqueResult();
	}

	public List<Blog> getAllBlogs() {
		
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
	}
	
	public List<Blog> getBlogsOfUser(String userID){
		return sessionFactory.getCurrentSession().createQuery("from Blog where blogCreatorId='"+userID+"'").list();
	}

}
