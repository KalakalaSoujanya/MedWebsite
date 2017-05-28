<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="java.util.List,com.medical.servlet.Doctor"%> 
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
<form action="Doctor?action=search" method="post">
<% String search=request.getParameter("search"); %>
<% String message=(String)request.getAttribute("message"); %>
<table width="70%" border="0" align="center">
<tr><td align="right"><input  type="text" name="search"  value="<%= ((search!=null)?search:"") %>"/><input type="submit" value="search" /></td></tr>
<tr><td>&nbsp;</td></tr>
</table>
</form>
<%= ((message!=null)?message:"") %>
<table width="60%" align="center" bgcolor="#cccccc" border="0" cellpadding="0" cellspacing="0">
<tr bgcolor="pink">
<th>DoctorId</th>
<th>DoctorLastName</th>
<th>DoctorFirstName</th>
<th>DoctorTitle</th>
<th>DoctorSpeciality</th>
<th>SendRequest</th>
</tr>

<%
List doctors=(List)request.getAttribute("doctors");
int length=doctors.size();
Doctor e= null;
for(int i=0;i<length;i++){
	e=(Doctor)doctors.get(i);
	%>
	
	<tr bgcolor="#cccccc"><td align="center"><%=e.getDoctorId()%></td>
	<td align="center"><%=e.getLastName() %></td>
	<td align="center"><%=e.getFirstName() %></td>
	<td align="center"><%=e.getTitle() %></td>
	<td align="center"><%=e.getSpeciality() %></td>
	<td align= "center"><a style="color:blue" href="Patient?action=sendRequest&doctorId=<%=e.getDoctorId()%>">SendRequestMessage</a></td></tr>
	<% } %>
</table>
</body>
</html>
