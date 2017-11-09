 
 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.27/angular.min.js"></script>
  <script src="app.js">
      
  </script>
 <style>
.floatLeft { width: 20%; float: left; }
.floatRight {width: 80%; float: right; }
</style>
</head>
<body>


<div class="container" ng-app="myApp" ng-controller="myCtrl">
   <div ng-init="getAllBlog();">
   <div ng-repeat="Blog in Bloglist">
<br/><strong><p><font style="text-transform: capitalize;">{{Blog.blogName}}</font></p></Strong><br/>
    
     Posted by :<i><b><font style="text-transform: capitalize;">{{Blog.blogCreatorId}} </font></b></i><br/>   
   Last Update on:{{Blog.lastUpdateDate}} <br/>
    {{Blog.blogData }}   <br/>
    <a ng-href="ViewBlog?bid={{Blog.blogID }}&uname=${uname}" class="btn btn-primary">View Blog</a>
   <a ng-href="removeBlog?bid={{Blog.blogID}}&uname=${uname}" class="btn btn-primary">Delete Blog</a>
    
  </div>
</div>
</td>
</tr>
</table>
</tr>
</div>
</div>



</body>
</html>