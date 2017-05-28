<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List,com.medical.servlet.Patient,com.medical.servlet.Doctor"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#ffffff">
<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<%String select=request.getSession().getAttribute("select").toString(); %>
<tr><td>&nbsp;&nbsp;</td></tr>
</table width="40%" >
<br><br>

<table align="center" width="30%" bgcolor="#cccccc">
<tr><td align="center"><h2>DoctorDashboard<h2></h2></tr></td>
<tr><td>&nbsp;</td></tr>
<tr><td align="center"><a style="color:blue" href="Doctor?action=currentPatientList">CurrentPatientList</a></td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td align="center"><a  style="color:blue" href="Patient?action=doctorDecision">PatientRequestList</a></td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td align="center"><a  style="color:blue" href="Patient?action=scheduledList">Schedule</a></td></tr>
<tr><td>&nbsp;</td></tr>
<tr><td align="center"><a  style="color:blue" href="MsgServlet?action=completeMsgList">Messages</a></td></tr>
<tr><td>&nbsp;</td></tr>
</table>

</body>
</html>