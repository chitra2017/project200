
var app = angular.module("myApp", [])
                 
app.controller('locationCtrl', function ($scope, $location) {

$scope.sparam=$location.search().uname;
$scope.bid=$location.search().bid;
$scope.fid=$location.search().fid;
$scope.forumid=$location.search().forumid;
});
app.controller('checkBoxController', function ($scope) {

});

app.controller("myCtrl",function ($scope,$window, $http) {
   
	$scope.validate= function() {
		
		  $http({
		          method : 'POST',
			//url address which we mention in controller
		          url : 'http://localhost:8080/social/validateUserRes/'+$scope.user.userName+'/'+$scope.user.userPassword
		  }).success(function(data, status, headers, config) {
			  
			  $scope.valid = data;
			  if( $scope.valid)
				  {
			         alert('Login Success');
		             
		     	      $window.location.href = 'http://localhost:8080/face/common/Home.html#?uname='+$scope.user.userName;
				  }
			  else
				  alert('Login Failed');
		  }).error(function(data, status, headers, config) {
			  
			  alert('Error.....');
		  });
		  
		},
		
		$scope.newUser= function() {
		
			 
			             $window.location.href = 'http://localhost:8080/face/user/Register.html';
			 
			  
			},
		

			  $scope.getFriends= function(uid) {
					 
			       $http({
			               method : 'GET',
					//url address which we mention in controller
			               url : 'http://localhost:8080/social/viewFriendsRes/'+uid
			       }).success(function(data, status, headers, config) {
				              $scope.friendlist = data;
				            //  $window.location.href = 'http://localhost:8080/face/UserFriends.html#?uname='+uid;
			       }).error(function(data, status, headers, config) {
			               
			       });
			},
		
			
			  $scope.getAllUser= function(uid) {
			  	
		          $http({
		                  method : 'GET',
				//url address which we mention in controller
		                  url : 'http://localhost:8080/social/viewAllUserRes/'+uid
		          }).success(function(data, status, headers, config) {
			              $scope.userlist = data; 
			              
		          }).error(function(data, status, headers, config) {
		                  
		          });
			},
			
			$scope.sendFriendRequest=function(user1,user2){
				 $http({
	                  method : 'GET',
			//url address which we mention in controller
	                  url : 'http://localhost:8080/social/sendFriendRequest/'+user1+'/'+user2
	          }).success(function(data, status, headers, config) {
		          alert('Request send to '+user1)    ;
		          $scope.getAllUser(user2);
		             
	          }).error(function(data, status, headers, config) {
	                  alert('Error.........');
	          });
				
			},
			
			$scope.acceptFriendRequest=function(user1,user2){
				 $http({
	                  method : 'GET',
			//url address which we mention in controller
	                  url : 'http://localhost:8080/social/acceptFriendRequest/'+user1+'/'+user2
	          }).success(function(data, status, headers, config) {
		          alert('Request Accepted given by '+user1)    ;
		          $scope.getReqFriends(user2);   
	          }).error(function(data, status, headers, config) {
	                  alert('Error.........');
	          });
				
			},
			

			$scope.rejectFriendRequest=function(user1,user2){
				 $http({
	                  method : 'GET',
			//url address which we mention in controller
	                  url : 'http://localhost:8080/social/rejectFriendRequest/'+user1+'/'+user2
	          }).success(function(data, status, headers, config) {
		          alert('Request Rejected given by '+user1)    ;
		          $scope.getReqFriends(user2);     
	          }).error(function(data, status, headers, config) {
	                  alert('Error.........');
	          });
				
			},
			$scope.getReqFriends= function(uid) {
				
				  $http({
				          method : 'GET',
					//url address which we mention in controller
				          url : 'http://localhost:8080/social/viewReqFriRes/'+uid
				  }).success(function(data, status, headers, config) {
				             $scope.reqfrilist = data; 
				  }).error(function(data, status, headers, config) {
				          
				  });
				  
				},

				$scope.selection=[];
				
				$scope.toggleSelection = function toggleSelection(fid) {
			    var idx = $scope.selection.indexOf(fid);

			    // is currently selected
			    if (idx > -1) {
			      $scope.selection.splice(idx, 1);
			    }

			    // is newly selected
			    else {
			      $scope.selection.push(fid);
			    }
			  },
			  $scope.createForum = function(uid) {
				  $http({
			          method : 'POST',
				//url address which we mention in controller
			          url : 'http://localhost:8080/social/addForumRes/'+$scope.Forum.ForumName+'/'+$scope.Forum.forumData+'/'+$scope.selection+'/'+uid
			  }).success(function(data, status, headers, config) {
				  
				  $scope.valid = data;
			  }).error(function(data, status, headers, config) {
				  
				  alert('Error.....');
			  });
				      
			  },
			  $scope.getAllForum= function(uid) {
				  //	alert('faf');
		        $http({
		                method : 'GET',
				//url address which we mention in controller
		                url : 'http://localhost:8080/social/viewAllForumRes/'+uid
		        }).success(function(data, status, headers, config) {
			              $scope.forumlist = data; 
			          //    alert('dfda');
		        }).error(function(data, status, headers, config) {
		                alert('Error in getting forum');
		        });
			},
			$scope.getAllfComm= function(fid) {

			    $http({
			            method : 'GET',
				//url address which we mention in controller
			            url : 'http://localhost:8080/social/viewAllForumCommRes/'+fid
			    }).success(function(data, status, headers, config) {
			              $scope.fcommlist = data; 
			          //    alert('dfda');
			    }).error(function(data, status, headers, config) {
			            alert('Error in getting comments ');
			    });
			},


			    $scope.createfcomment = function(uid,fid) {				
			    		alert(fid);
			    		alert(uid);
			    		alert($scope.ForumComment.commentText);
			    	  $http({
				          method : 'POST',
					 url : 'http://localhost:8080/social/addCommForumRes/'+uid+'/'+fid+'/'+$scope.ForumComment.commentText         
			        }).success(function(data, status, headers, config) {
			        	alert('success');
			            $scope.fcomm = data;
			            $scope.getAllfComm(fid);
			            //  $window.location.href = 'http://localhost:8080/face/UserFriends.html#?uname='+uid;
			   }).error(function(data, status, headers, config) {
			           alert('error in posting comments');
			   });  
			},
			  $scope.viewforum= function(forumid) {
			  	alert(forumid);
		    $http({
		            method : 'GET',
			//url address which we mention in controller
		            url : 'http://localhost:8080/social/viewForumRes/'+forumid
		    }).success(function(data, status, headers, config) {
		              $scope.forum = data; 
		          //    alert('dfda');
		    }).error(function(data, status, headers, config) {
		            alert('Error');
		    });
		};
			    





  

   });

