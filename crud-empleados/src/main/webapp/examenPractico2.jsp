<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Nombre y Apellido de todos los empleados</h1>
	
	<ul>
		<%
			List<String> nombreYApellidos = (List<String>) request.getAttribute("nombreYApellidos");
		
			for (String nombreYApellido : nombreYApellidos) {
				%>
				
				<li><%=nombreYApellido %></li>
				<% 
			}
		%>
	</ul>
</body>
</html>