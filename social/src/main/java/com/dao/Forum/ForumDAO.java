package com.dao.Forum;

import java.util.List;

import com.model.*;

public interface ForumDAO {
	
	public Forum createForum(String fname ,String fdata,List members,String uid);
	
	
	public Forum getForumById(int ForumID);
	
	public List<Forum> getAllForum(String uid);
	
	
	public List<Members> getMembers(int ForumID);
	
	
	
	
	
	
}
