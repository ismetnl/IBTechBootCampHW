<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String username = (String)session.getAttribute("username");
	
	if(username == null){
		response.sendRedirect("http://localhost:8080/HW-05-02/Login.jsp");
	}
	
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<span>Hoşgeldin <%=username%></span><br/><br/>
<a href="Logout.jsp">Çık</a>
</body>
</html>