<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String username="";
	String password="";
	String message ="";
	
	if(request.getParameter("login") != null){
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		if(username == ""){
			message = "Lutfen kullanıcı adı giriniz";
		}
		else if(password == ""){
			message = "Lutfen şifreyi giriniz";
		}
		else{
			if(username.equals("godoro") && password.equals("java")){
				session.setAttribute("username", username);
				response.sendRedirect("http://localhost:8080/HW-05-02/Home.jsp");
			}
			else{
				message = "Yanlış kullanıcı adı veya şifre";
			}
		}
	}
%>    
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form action="Login.jsp" method="post">
                            <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" value="<%=username%>" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="text" name="password" value="<%=password%>" class="form-control">
                            </div>
                            <div class="form-group">
                             	<label style="color: red;"><%=message %></label><br>
                                <input type="submit" name="login" class="btn btn-info btn-md" value="login">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>