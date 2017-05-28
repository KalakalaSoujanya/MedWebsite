<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.List,com.medical.servlet.Patient,com.medical.servlet.Doctor,com.medical.servlet.Test"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/></script>
<script>
$(function(){
	
	$("#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
	showButtonPanel:true
	
});
</script>






</head>
<body bgcolor="#ffffff">
<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<tr><td>&nbsp;&nbsp;</td></tr>
</table>
</br></br></br>
<% String doctorId=request.getSession().getAttribute("doctorId").toString();%>
<%String patientId=request.getAttribute("patientId").toString(); %>
<form method="post" action="Doctor?action=resultsFormDetails&patientId=<%=patientId%>">

<table width="30%" bgcolor="#808080" align="center">
<tr><td align="center" colspan="3"><h2>TestResults</h2></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;</td><td><b>PatientId</b></td><td><%=patientId %></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;</td><td><b>DoctorId</b></td><td><%=doctorId %></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;</td><td><b>TestId</b></td><td><input type="text" name="testId" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>ResultsDate</b></td><td><input type="text" name="date" id="datepicker"></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>NormalRange</b></td><td><input type="text" name="normalRange" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>ActualResult</b></td><td><input type="text" name="actualResult" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>ResultsNote</b></td><td><input type="text" name="testResultsNote" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td align="center" colspan="3"><input type="submit" name="Submit" /></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr></table></form>

</body> 
</html>