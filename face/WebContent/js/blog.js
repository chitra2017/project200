 

app.controller("myCtrl1",function ($scope,$window, $http) {
	  $scope.getAllBlog= function(uid) {
		  	//alert('faf');
        $http({
                method : 'GET',
		//url address which we mention in controller
                url : 'http://localhost:8080/social/viewAllBlogRes/'+uid
        }).success(function(data, status, headers, config) {
	              $scope.bloglist = data; 
	          //    alert('dfda');
        }).error(function(data, status, headers, config) {
                alert('Error');
        });
	},

	  $scope.getAllComm= function(bid) {

    $http({
            method : 'GET',
	//url address which we mention in controller
            url : 'http://localhost:8080/social/viewAllCommRes/'+bid
    }).success(function(data, status, headers, config) {
              $scope.commlist = data; 
          //    alert('dfda');
    }).error(function(data, status, headers, config) {
            alert('Error');
    });
},
$scope.getAllComm1= function() {

$http({
        method : 'GET',
//url address which we mention in controller
        url : 'http://localhost:8080/social/viewAllComm1'
}).success(function(data, status, headers, config) {
          $scope.commlist = data; 
      //    alert('dfda');
}).error(function(data, status, headers, config) {
        alert('Error');
});
},
    $scope.create = function(uid) {
    	    
        var formData = new FormData();

        //$scope.dataform = {};
        formData.append('formdata', JSON.stringify($scope.blog));
        $http.post('http://localhost:8080/social/addBlogRes/'+uid, formData, {
            transformRequest : function(data, headersGetterFunction) {
                return data;
            },
            headers : {
                'Content-Type' : undefined
            }
        }).success(function(data, status, headers, config) {
      		//the server get the data from controller and assigning the Products
        	  alert('Blog Created');
                  $scope.blog = data; 
                  //$window.location.href = 'http://localhost:8080/face/index.jsp';
                  $scope.blog.blogName=null;    
                  $scope.blog.blogDescription=null;
                  $scope.blog.blogData=null;
          }).error(function(data, status, headers, config) {
                  alert("Error in Blog creation");
          });
      
    },

    $scope.createcomment = function(uid,bid) {
    		
    	  $http({
	          method : 'POST',
		//url address which we mention in controller
	          url : 'http://localhost:8080/social/addCommBlogRes/'+uid+'/'+bid+'/'+$scope.Comment.commentText         
        }).success(function(data, status, headers, config) {
        	alert('success');
            $scope.comm = data;
            $scope.getAllComm(bid);
            //  $window.location.href = 'http://localhost:8080/face/UserFriends.html#?uname='+uid;
   }).error(function(data, status, headers, config) {
           alert('error');
   });  
},
    

	  $scope.viewBlog= function(bid) {
	  	//alert('faf');
    $http({
            method : 'GET',
	//url address which we mention in controller
            url : 'http://localhost:8080/social/viewBlogRes/'+bid
    }).success(function(data, status, headers, config) {
              $scope.Blog = data; 
          //    alert('dfda');
    }).error(function(data, status, headers, config) {
            alert('Error');
    });
};
	 

	  

})
