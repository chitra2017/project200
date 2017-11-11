package com.dao;

import java.util.Date;
import java.util.List;



import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.dao.*;
import com.model.*;


public class CommentDAOImpl implements CommentDAO {
	
	
	
	private SessionFactory sessionFactory;
	
	CommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public List<Comment> getAllComments() {
	return sessionFactory.getCurrentSession().createQuery("from Comment").list();
	}

	public List<Comment> getAllComments(long blogID) {
		return sessionFactory.getCurrentSession().createQuery("from Comment where blogID='"+blogID+"'").list();
	}

	public Comment addComment(long blogID, String comment_UserId, String commentData) {
			Comment comment=new Comment();
			comment.setBlogID(blogID);
			comment.setCommentUserId(comment_UserId);
			comment.setCommentText(commentData);
			comment.setCommentDate(new Date());
			
			sessionFactory.getCurrentSession().save(comment);
		
			//System.out.println("ffasdff--------------------------------------------");
			return comment;
		
	}



	
	public Comment getComment(long commentID){
		return (Comment) sessionFactory.getCurrentSession().get(Comment.class, commentID);
	}



}
