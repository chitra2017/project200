package com.dao.Forum;

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
public class ForumComDAOService {
	
	
	@Autowired
	private ForumCommentDAOImpl cimpl;

	public List<ForumCom> getAllComments(int forumID) {
		return cimpl.getAllComments(forumID);
	}
	

	public ForumCom addComment(int forumID,String comment_UserId,String commentData) {
		return cimpl.addComment(forumID, comment_UserId, commentData)	;}

	
	

	
	
	public ForumCom getComment(long commentID){
		return cimpl.getComment(commentID);
	}


	
}
