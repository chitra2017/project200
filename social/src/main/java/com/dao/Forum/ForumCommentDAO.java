package com.dao.Forum;

import java.util.List;

import com.model.*;

public interface ForumCommentDAO {

	public List<ForumCom> getAllComments(int forumID);
	//public List<ForumComment> getAllComments();
	
	public ForumCom addComment(int forumID,String comment_UserId,String commentData);
	
	
	

	public ForumCom getComment(long commentID);

}
