<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.List,com.medical.servlet.Patient,com.medical.servlet.Doctor,com.medical.servlet.Test"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ffffff">
<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<tr><td>&nbsp;&nbsp;</td></tr>
</table>
</br></br></br>

<form method="post" action="">
<%Test fullForm=(Test)request.getAttribute("fullForm"); %>
<table align="center" width="40%" border="0" cellpadding="0" cellspacing="0" bgcolor="#cccccc">
<tr bgcolor="pink"><td align="center" colspan="3" ><h2>View Prescription</h2></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>TestId</b></td><td><%=fullForm.getTestId()  %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>TestDate</b></td><td><%= fullForm.getD2() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>TestName</b></td><td><%=fullForm.getTestName()  %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>DoctorId</b></td><td><%=fullForm.getDoctorId() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>PatientId</b></td><td><%=fullForm.getPatientId() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>DoctorNote</b></td><td><%=fullForm.getDoctorNote() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
</table>
<br>
<br>
<br>
 
 
 </table>

</body>
</html>