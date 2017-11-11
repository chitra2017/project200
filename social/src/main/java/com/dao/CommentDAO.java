package com.dao;

import java.util.List;

import com.model.Comment;

public interface CommentDAO {

	public List<Comment> getAllComments(long blogID);
	public List<Comment> getAllComments();	
	public Comment addComment(long blogID,String comment_UserId,String commentData);
	public Comment getComment(long commentID);

}
