package com.controller;

import com.dao.user.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

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
public class UserRestController
{

	@Autowired
	private UserDAOService us;
	
/*
	String name;
	@GetMapping(value="/viewBlogRes/{bid}") 		  
	public ResponseEntity<Blog> viewBlog(@PathVariable("bid") long bid){
		
	   	return new ResponseEntity<Blog>(bs.getBlogById(bid),HttpStatus.OK);

	 		  
	  }
	*/  
	
	
	@RequestMapping("/sendFriendRequest/{fid}/{uid}")
	public  ResponseEntity<List<Friend>> sendFriendRequest(@PathVariable("fid") String fid,@PathVariable("uid") String uid){
		boolean valid=us.sendFriendRequest(uid, fid);
	return	new ResponseEntity<List<Friend>>(us.getAllFriendsOfUser(uid),HttpStatus.OK);
	

		
		
	}
	
	@RequestMapping("/acceptFriendRequest/{fid}/{uid}")
	public  ResponseEntity<List<Friend>> acceptFriendRequest(@PathVariable("fid") String fid,@PathVariable("uid") String uid){
		boolean valid=us.acceptFriendRequest(uid, fid);
	return	new ResponseEntity<List<Friend>>(us.getAllFriendsOfUser(uid),HttpStatus.OK);
	

		
		
	}
	@RequestMapping("/rejectFriendRequest/{fid}/{uid}")
	public  ResponseEntity<List<Friend>> rejectFriendRequest(@PathVariable("fid") String fid,@PathVariable("uid") String uid){
		boolean valid=us.rejectRequest(uid, fid);
	return	new ResponseEntity<List<Friend>>(us.getAllFriendsOfUser(uid),HttpStatus.OK);
	

		
		
	}
	
	@GetMapping(value="/viewAllUserRes/{uid}") 		  
	public ResponseEntity<List<User>> viewAllUser(@PathVariable("uid") String uid){
		System.out.println("Getting All users");
		
	   	return new ResponseEntity<List<User>>(us.getAllUsers(uid),HttpStatus.OK);

	 		  
	  }
	
	@GetMapping(value="/viewFriendsRes/{uid}") 		  
	public ResponseEntity<List<Friend>> viewFriends(@PathVariable("uid") String uid){
		
		System.out.println("Rest --------------------"+us.getFriendsOfUser(uid).size());
	   	return new ResponseEntity<List<Friend>>(us.getFriendsOfUser(uid),HttpStatus.OK);

	 		  
	  }
	
	@GetMapping(value="/viewReqFriRes/{uid}") 		  
	public ResponseEntity<List<Friend>> viewReqFriends(@PathVariable("uid") String uid){
		
		System.out.println(us.getFriendsReqOfUser(uid).size());
	   	return new ResponseEntity<List<Friend>>(us.getFriendsReqOfUser(uid),HttpStatus.OK);

	 		  
	  }
	
	
	@PostMapping(value="/validateUserRes/{userName}/{userPassword}")
public ResponseEntity <User> validate(@PathVariable("userName") String uname,@PathVariable("userPassword") String upass){
	
		if(us.userValidate(uname,upass))
		{System.out.println("valid user.......");		
			return new ResponseEntity<User>(us.getUserById(uname),HttpStatus.OK);
		}
		else
		{System.out.println("not avalid user.......");
			return null;
		}
	 		  
	  }

	@RequestMapping(value = "/up", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public @ResponseBody ResponseEntity<User> storeAd1(@Valid @RequestParam("formdata") String user1,MultipartHttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		User user = new ObjectMapper().readValue(user1, User.class);
		boolean valid=us.createUser(user);
            	System.out.println(request.getFile("file").getOriginalFilename());
            	System.out.println(user.getUserName());
            	
            	String path1=request.getRealPath(user.getUserID()+".jpg"); 
            	System.out.println(path1);
            	
		    	int res = 0;
		    	File f=new File(path1);
		    	if(!request.getFile("file").isEmpty()) {
		       	try { //filename=p.getImage().getOriginalFilename();
		    		byte[] bytes=request.getFile("file").getBytes(); 
		    		BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
		    		bs.write(bytes); bs.close(); 
		    		System.out.println("Image uploaded");
		    	}catch(Exception ex)
	       		{
	       			System.out.println(ex.getMessage());
	       		}

		    	}


     		   
    			return new ResponseEntity<User>(user,HttpStatus.OK);         
        
    }
	
	
	
	@PostMapping(value="/addUserRes/{userId}/{userName}/{password}")
	public ResponseEntity<User> createBlog1(@PathVariable("userId") String userId,@PathVariable("userName") String userName ,
			@PathVariable("password") String password	){
		System.out.println("fahfagfashdsadfafalkj");
	User newUser=new User();
	newUser.setUserID(userId);
	newUser.setUserName(userName);
	newUser.setUserPassword(password);
		boolean valid=us.createUser(newUser);
		
		
		
		   
			return new ResponseEntity<User>(newUser,HttpStatus.OK);
	
	}

    @MessageMapping("/hello")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws java.lang.Exception{
      
    // message.setFrom("message");
        return new OutputMessage(message.getFrom(), message.getTo(),message.getText());
        
    }
    


	
}