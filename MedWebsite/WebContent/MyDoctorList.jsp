<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="java.util.List,com.medical.servlet.Doctor,com.medical.servlet.Message"%> 
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
<%-- <form method="post">
<% String search=request.getParameter("search"); %>
<% String messge=(String)request.getAttribute("messageSent");%>
<table width="60%" border="0" align="center">
<tr><td align="right"><input  type="text" name="search"  value="<%= ((search!=null)?search:"") %>"/><input type="submit" value="search" /></td></tr>
<tr><td>&nbsp;</td></tr>
</table>
</form> --%>

<%String message=(String)request.getAttribute("message"); %>
<form   method="post" action="">

<table width="60%" align="center" bgcolor="white" border="0" cellpadding="0" cellspacing="0">
<tr bgcolor="pink">
<th>DoctorId</th>
<th>DoctorLastName</th>
<th>DoctorFirstName</th>
<th>DoctorTitle</th>
<th>DoctorSpeciality</th>
<th>MessageBox</th>
<th>Appointments</th>
<th>View TestResults</th>
</tr>

<%
List myDoctorsList=(List)request.getAttribute("myDoctorsList");
int length=myDoctorsList.size();
Doctor e= null;
for(int i=0;i<length;i++){
	e=(Doctor)myDoctorsList.get(i);
	%>
	
	<tr bgcolor="#cccccc" align="center"><td><%=e.getDoctorId()%></td>
	<td align="center"><%=e.getLastName() %></td>
	<td align="center"><%=e.getFirstName() %></td>
	<td align="center"><%=e.getTitle() %></td>
	<td align="center"><%=e.getSpeciality() %></td>
	<td align= "center"><a  style="color:blue" href="MsgServlet?action=sendMessage&doctorId=<%=e.getDoctorId()%>">SendMessage</a></td>
	<td align= "center"><a  style="color:blue" href="Patient?action=appointmentPage&doctorId=<%=e.getDoctorId()%>">Book Appointment</a></td>
	<td align= "center"><a  style="color:blue" href="Patient?action=testResultsList&doctorId=<%=e.getDoctorId()%>">TestResults </a></td>
	</tr>
	
	<% } %>
</table>
</form>
</body>
</html>
