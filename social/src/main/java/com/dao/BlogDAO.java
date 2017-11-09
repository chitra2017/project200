package com.dao;

import java.util.List;

import com.model.Blog;



public interface BlogDAO {
	
	public boolean createBlog(Blog blog);
	
	public boolean updateBlog(Blog blog);
	
	public boolean removeBlog(long blogId);
	
	public boolean removeBlog(Blog blog);
	
	public Blog getBlogById(long blogID);
	
	public List<Blog> getAllBlogs();
	
	public List<Blog> getBlogsOfUser(String userID);
	
}
