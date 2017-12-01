
<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="hst.*" import="org.bson.types.ObjectId"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		EmployeUpadte id = new EmployeUpadte();
	%>
	<form method="post" action="">
		<input type="text" value="ObjectId"> Enter the ObjectId to be
		updated :<%
			String FileId = request.getParameter("ObjectId");
		ObjectId id1 = new ObjectId(FileId);
		%>
		<input type="text" value="Filename"> Enter the ObjectId to be
		updated :<%
			String Filename = request.getParameter("Filename");
		%>

		<input type="submit" value="submit">
		<%
			
			id.rename(id1, Filename);
		%>

	</form>




</body>
</html>