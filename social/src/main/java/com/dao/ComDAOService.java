package com.dao;

import java.util.Date;
import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.*;
import com.model.*;


@Service     
@Transactional
public class ComDAOService {
	
	
	@Autowired
	private CommentDAOImpl cimpl;

	public List<Comment> getAllComments(long blogID) {
		return cimpl.getAllComments(blogID);
	}
	public List<Comment> getAllComments(){
		return cimpl.getAllComments();
	}

	public Comment addComment(long blogID, String comment_UserId, String commentData) {
		return cimpl.addComment(blogID, comment_UserId, commentData)	;}

	
	
	public Comment getComment(long commentID){
		return cimpl.getComment(commentID);
	}


	
}
