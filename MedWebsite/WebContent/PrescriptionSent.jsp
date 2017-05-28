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
</head>
<body bgcolor="#ffffff">
<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<tr><td>&nbsp;&nbsp;</td></tr>
</table>
</br></br></br>
<form>
<%String patientId=request.getAttribute("patientId").toString(); %>
<table align="center" width="30%" bgcolor="#cccccc">
<tr><td align="center"><h4>PrescriptionSentSuccessfully</h4></td></tr>
<tr><td align="center" text-color="blue"><a href="Doctor?action=currentPatientList"?>Back to DashBoard</a></td></tr>
<tr><td  align="center"><a href="Doctor?action=Prescription&patientId=<%=patientId%>"/>Add More Prescriptions</td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
</table>
</form>
</body> 
</html>