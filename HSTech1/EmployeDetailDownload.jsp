<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="hst.*" import="org.bson.types.ObjectId"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<center>
	<img alt="HSttechnologies" src="E:\\sk\\HSTech2.jpg"><br>

	<title>HS Technologies</title>
	<%
		String type = request.getParameter("type");
		String Path = request.getParameter("Path");
		EmployeDetailDownload id = new EmployeDetailDownload();
	%>

</head>
<body>

	<%
		if ("AttachmentName".equals(type)) {

			String AttachmentName = request.getParameter("Value");
			out.print(id.AttachmentName(AttachmentName, Path));
		}
		if ("FileId".equals(type)) {

			String FileId = request.getParameter("Value");
			ObjectId id1 = new ObjectId(FileId);
			out.print(id.Fileid(id1, Path));
		}
	%>
	<nav> <a href="EmployeDetailFind.html"> <element>Employee
		Dteails Find</element></a> | <a href="EmployeDetailEntry.html">Employee Dteails
		Entry</a> | <a href="EmployeDetailDownload.html">EmployeDetailDownload
	</a> <a href="EmployeAttachmentUpdate.html">EmployeDetailDownload
	</a></nav>
</body>
</html>