<%@ page import="com.ibtech.geometry.Rectangle" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Rectangle rectangle = new Rectangle();
	int height = 0;
	int width = 0;
	int result = 0;
	
	if(request.getParameter("area") != null || request.getParameter("perimeter") != null){
		height = Integer.parseInt(request.getParameter("height"));
		width = Integer.parseInt(request.getParameter("width"));
		rectangle.setHeight(height);
		rectangle.setWidth(width);
		
		if(request.getParameter("area") != null){
			result = rectangle.getArea();
		}
		else{
			result = rectangle.getPerimeter();
		}
	}
%>    

<!DOCTYPE html>
<html>
<head>
<style type="text/css">

.top-left{
position: fixed;
left: 10px;
top: 10px;
}

</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Rectangle</title>
</head>
<body>
<form action="Rectangle.jsp" method="POST">
	<div class = "top-left">
		<div class="form-group">
			<label class="text-info">Sonuç : <%=result %></label>
		</div>
		<div class="form-group">
			<label for = "height" class="text-info">Uzunluk:</label>
			<input type = "text" name= "height" value="<%=height%>"/>
		</div>
		<div class="form-group">
			<label for = "height" class="text-info">Genişlik:</label>
			<input type = "text" name= "width" value="<%=width%>"/>
		</div>
		<div class="form-group">
			<button type="submit" name= "area" class="btn btn-primary">Alan Hesapla</button>
	 		<button type="submit" name= "perimeter" class="btn btn-primary">Çevre Hesapla</button>
		</div>
	</div>
</form>
</body>
</html>