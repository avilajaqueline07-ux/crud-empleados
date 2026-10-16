<%@page import="java.util.List"%>
<%@page import="com.example.model.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detalles</title>
</head>
<body>
	<%
		Empleado empleado = (Empleado) request.getAttribute("empleado");
		String nombreDpto = (String) request.getAttribute("nombreDpto");
		List<String> telefonos = (List<String>) request.getAttribute("telefonos");
	%>
	<h1>Detalles del empleado: <%=empleado.nombre() + " "
	            + empleado.apellido1() + " "
	            + empleado.apellido2() %></h1>
	            
	 <h3>Departamento: <%=nombreDpto %></h3>
	 
	 <h3>Telefonos: </h3>
	 
	 <ul>
	 	<%
	 		for (String numero : telefonos) {
	 			%>
	 			<li><%=numero %></li>
	 			<%
	 		}
	 	%>
	 </ul>
	            
</body>
</html>