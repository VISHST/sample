<%@page import="org.apache.catalina.connector.Response"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="hst.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HS technologies</title>
<center>
	<img alt="HSttechnologies" src="E:\\sk\\HSTech2.jpg"><br>
	<center>
</head>


<body>
	<%
		String FirstName = request.getParameter("FirstName");
		String MiddleName = request.getParameter("MiddleName");
		String LastName = request.getParameter("LastName");
		String ContactNum1 = request.getParameter("ContactNum1");
		String ContactNum2 = request.getParameter("ContactNum2");
		String MailAddress = request.getParameter("MailAddress");
		String VisaType = request.getParameter("VisaType");
		String VisaDocument = request.getParameter("VisaDocument");
		String IDProofDocument = request.getParameter("IDProofDocument");
		String Resume = request.getParameter("Resume");
		String Comments = request.getParameter("Comments");

		EmployeDetailEntry id = new EmployeDetailEntry();
	%>
	<%
		id.upload(FirstName, MiddleName, LastName, MailAddress, VisaType, VisaDocument, IDProofDocument, Resume,
				Comments, ContactNum1, ContactNum2);
	%>

	<nav> <a href="EmployeDetailFind.html"> <element>Employee
		Dteails Find</element></a> | <a href="EmployeDetailEntry.html">Employee Dteails
		Entry</a> | <a href="EmployeDetailDownload.html">EmployeDetailDownload
	</a> <a href="EmployeAttachmentUpdate.html">EmployeDetailDownload
	</a></nav>
</body>

</html>