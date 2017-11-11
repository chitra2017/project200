package com.controller;

import com.dao.ComDAOService;
import com.dao.Forum.ForumComDAOService;
import com.dao.Forum.ForumDAOService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by sazzad on 2/11/16
 */
@RestController
public class ForumRestController
{

	@Autowired
	private ForumDAOService fs;
	@Autowired
	private ForumComDAOService fcs;

	@GetMapping(value="/viewForumRes/{forumid}") 		  
	public ResponseEntity<Forum> viewBlog(@PathVariable("forumid") int forumid){
		
	   	return new ResponseEntity<Forum>(fs.getForumById(forumid),HttpStatus.OK);

	 		  
	  }

	

	@PostMapping("/addForumRes/{fname}/{fdata}/{members}/{uid}")			
	public @ResponseBody ResponseEntity<Forum> storeAd2(
			@PathVariable("fdata") String fdata ,
			@PathVariable("fname") String fname,@PathVariable("members") List members,
			@PathVariable("uid") String uid){
		String s="";
		String s1="";
	    for (int i = 0; i < members.size() ; i++) {
	    	s1=members.get(i).toString();
	    	s=s+s1;
	    	if (i!=members.size()-1)
	    	s=s+",";
	    	
	 
	    }
	    System.out.println("------------"+s+"--------");
		Forum f1=fs.createForum(fname,fdata,s,uid);
		
		
		
		
		return new ResponseEntity<Forum>(f1,HttpStatus.OK);    
		
    
	}
	@GetMapping(value="/viewAllForumRes/{uid}") 		  
	public ResponseEntity<List<Forum>> viewAllUser(@PathVariable("uid") String uid){
		System.out.println("Getting All Related Forum ");
		
	   	return new ResponseEntity<List<Forum>>(fs.getAllForum(uid),HttpStatus.OK);

	 		  
	  }
	@GetMapping(value="/viewAllForumCommRes/{fid}") 		  
	public ResponseEntity<List<ForumCom>> viewAllComm(@PathVariable("fid") int fid){
		
		
	   	return new ResponseEntity<List<ForumCom>>(fcs.getAllComments(fid),HttpStatus.OK);

	 		  
	  }
	@PostMapping("/addCommForumRes/{uid}/{fid}/{commentText}")
public ResponseEntity<ForumCom> createcomm(
		@PathVariable("uid")  String uid,
		@PathVariable("fid")  int fid,
		@PathVariable("commentText")  String commtext) {
	
		System.out.println("........................");
	ForumCom comm=fcs.addComment(fid,uid, commtext);
	System.out.println(comm.getCommentText()+"........................");
	return new ResponseEntity<ForumCom>(comm,HttpStatus.OK);    
	

}  


		
}