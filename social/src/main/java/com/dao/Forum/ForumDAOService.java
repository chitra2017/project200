package com.dao.Forum;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;

import com.model.*;
@Service     
@Transactional
public class ForumDAOService{
	@Autowired
	private ForumDAOImpl fp;
	

	public Forum createForum(String fname ,String fdata,String members,String uid){
	return fp.createForum(fname, fdata, members,uid);
}
	
	
	public Forum getForumById(int ForumID){
		return fp.getForumById(ForumID);
	}
	
	public List<Forum> getAllForum(String uid){
		return fp.getAllForum(uid);
	}
	
	
	public List<Members> getMembers(int ForumID){
		return fp.getMembers(ForumID);
	}
	
	
	
}