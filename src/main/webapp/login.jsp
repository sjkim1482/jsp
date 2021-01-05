<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Signin Template for Bootstrap **</title>
	<%@include file="/common/common_lib.jsp" %>
    
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">


  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="<%=request.getContextPath()%>/loginController" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">userid</label>
        <input type="text" name="userid" value="brown" id="userid" class="form-control" placeholder="아이디 입력" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="pass" value="brownpass" name="pass" class="form-control" placeholder="패스워드 입력" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
