<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<br><br><br>
<form>
<%String doctorId=request.getParameter("doctorId"); %>
<table align="center" width="30%" bgcolor="#cccccc">
<tr><td align="center"><h4>Appointment Confirmed</h4></td></tr>
<tr><td align="center"><a  style="color:blue" href="Patient?action=myDoctorList">Back to DashBoard</a></td></tr>
<tr><td  align="center"><a   style="color:blue" href="Patient?action=appointmentPage&doctorId=<%=doctorId%>">Want to Book more Appointment</a></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
</table>
</form>
</body>
</html>