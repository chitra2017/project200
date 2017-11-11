package com.dao.Forum;

import java.util.Date;
import java.util.List;



import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.dao.*;
import com.model.*;


public class ForumCommentDAOImpl implements ForumCommentDAO {
	
	
	
	private SessionFactory sessionFactory;
	
	ForumCommentDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public List<ForumCom> getAllComments(int forumID) {
	return sessionFactory.getCurrentSession().createQuery("from ForumCom where forumID="+forumID).list();
	}

	

	public ForumCom addComment(int forumID,String comment_UserId,String commentData){
			ForumCom comment=new ForumCom();
			comment.setForumID(forumID);
			comment.setCommentUserId(comment_UserId);
			comment.setCommentText(commentData);
			comment.setCommentDate(new Date());
			
			sessionFactory.getCurrentSession().save(comment);
		
			System.out.println("ffasdff--------------------------------------------");
			return comment;
		
	}


	
	public ForumCom getComment(long commentID){
		return (ForumCom) sessionFactory.getCurrentSession().get(ForumCom.class, commentID);
	}



}
