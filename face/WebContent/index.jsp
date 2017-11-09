

<!DOCTYPE html>
<html>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script type="text/javascript" src="/face/lib/Bootstrap/bootstrap.js"></script>
<link rel="stylesheet" href="/face/lib/Bootstrap/bootstrap.min.css">
  <script src="js/app.js"></script>

<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 400px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}


</style>

<script type = "text/javascript" >
   function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
</script>
</head>

<body onload="preventBack();" style="background-color:lightGray;">
<div class="element" style="width:100%;length:100%;">
<div style=" text-shadow: 5px 5px 2px gray; text-transform: uppercase;color:blue">
<b><font face="Times New Roman" size="6"><center> Space Book </center></font></b>
</div>

	<div id="login-box">

		<h3>Login</h3>

		
		<div class="container" ng-app="myApp" ng-controller="myCtrl">

  <form ng-submit="validate()" >
  <table>
    <tr>
   <td>User:</td>
    <td><input type="text"  placeholder="User" name="userName" ng-model="user.userName" autofocus></td>
    </tr>
    <tr>
    <td>Password:</td>
     <td><input type="text"  placeholder="User" name="userPassword" ng-model="user.userPassword"></td>
     </tr>
     <tr>
     <td>
      <input type="submit"  value="login"   class="btn btn-primary">
      </td>
      </tr>
       </table>
  </form>
  <br/>
      <button ng-click="newUser()" class="btn btn-primary">Register</button>

</div>
</div>
	
	
</body>
</html>