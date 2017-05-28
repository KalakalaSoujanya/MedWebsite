<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.List,com.medical.servlet.Patient,com.medical.servlet.Doctor,com.medical.servlet.Test,com.medical.servlet.TestResult"%>
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
<% String select=request.getSession().getAttribute("select").toString();%>
<%String doctorId=null;
String patientId=null;
%>
<%if(select.equals("Doctor")){ %>
<%  doctorId=request.getSession().getAttribute("doctorId").toString();%>
<% patientId=request.getAttribute("patientId").toString(); %>
<%}else {%>
<%  patientId=request.getSession().getAttribute("patientId").toString();%>
<%  doctorId=request.getAttribute("doctorId").toString();%>

<%} %>

<%TestResult r=(TestResult)request.getAttribute("r"); %>
<table align="center" width="40%" border="0" cellpadding="0" cellspacing="0" bgcolor="#cccccc">
<tr bgcolor="pink"><td align="center" colspan="3" ><h2>View Test Results</h2></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>DoctorId</b></td><td><%=doctorId %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>PatientId</b></td><td><%=patientId %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>ResultId</b></td><td><%=r.getResultId() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>TestId</b></td><td><%=r.getTestId()  %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>TestDate</b></td><td><%= r.getD2() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>normalRange</b></td><td><%=r.getNormalRange()  %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>actualResult</b></td><td><%=r.getActualResult() %></td></tr>
<tr><td>&nbsp;<td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><b>ResultNote</b></td><td><%=r.getTestResultsNote() %></td></tr>
<tr><td>&nbsp;<td></tr>

<tr><td>&nbsp;<td></tr>
</table>
<br>
<br>
<br>
 
 
 
</form>
</body>
</html>