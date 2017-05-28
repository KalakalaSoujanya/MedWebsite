<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.medical.servlet.Doctor,com.medical.servlet.Patient" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int patientId=Integer.parseInt("patientId");%>
<% int doctorId=Integer.parseInt("doctorId");%>
<tr><th>PatientId</th>
<th>DoctorId</th>
<th>MessageId</th>
<th>SenderName</th>
<th>Display</th>
<th>MessageBox</th></tr>
<br><br>

<tr><td><input type="button" value="Send"/></td></tr>
</body>
</html>