package com.controller;

import com.dao.BlogDAOService;
import com.dao.ComDAOService;
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

/**
 * Created by sazzad on 2/11/16
 */
@RestController
public class BlogRestController
{

	@Autowired
	private BlogDAOService bs;
	
	@Autowired
	private ComDAOService cs;

	String name;
	@GetMapping(value="/viewBlogRes/{bid}") 		  
	public ResponseEntity<Blog> viewBlog(@PathVariable("bid") long bid){
		
	   	return new ResponseEntity<Blog>(bs.getBlogById(bid),HttpStatus.OK);

	 		  
	  }
	  
	@GetMapping(value="/viewAllBlogRes/{uid}") 		  
	public ResponseEntity<List<Blog>> viewAllBlog(@PathVariable("uid") String uid){
		
		
	   	return new ResponseEntity<List<Blog>>(bs.getAllBlogs(),HttpStatus.OK);

	 		  
	  }
	
	@GetMapping(value="/viewAllCommRes/{bid}") 		  
	public ResponseEntity<List<Comment>> viewAllComm(@PathVariable("bid") long bid){
		
		
	   	return new ResponseEntity<List<Comment>>(cs.getAllComments(bid),HttpStatus.OK);

	 		  
	  }
	
	@GetMapping(value="/viewAllComm1") 		  
	public ResponseEntity<List<Comment>> viewAllComm1(){
		
		
	   	return new ResponseEntity<List<Comment>>(cs.getAllComments(),HttpStatus.OK);

	 		  
	  }

	@PostMapping("/addBlogRes/{uid}")			
	public @ResponseBody ResponseEntity<Blog> storeAd1(@RequestParam("formdata") String blog1,
			@PathVariable("uid")  String uid) throws JsonParseException, JsonMappingException, IOException{
		
		Blog blog = new ObjectMapper().readValue(blog1, Blog.class);
		blog.setBlogCreatorId(uid);
		boolean valid=bs.createBlog(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);    
		
    
	}
		@PostMapping("/addCommBlogRes/{uid}/{bid}/{commentText}")
	public ResponseEntity<Comment> createcomm(
			@PathVariable("uid")  String uid,
			@PathVariable("bid")  long bid,
			@PathVariable("commentText")  String commtext) {
		
			System.out.println("........................");
		Comment comm=cs.addComment(bid,uid, commtext);
		System.out.println(comm.getCommentText()+"........................");
		return new ResponseEntity<Comment>(comm,HttpStatus.OK);    
		
    
	}  
	
	
}