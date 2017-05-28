<%@page import="java.nio.channels.SelectableChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.medical.servlet.Message,com.medical.servlet.MsgList"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" >
<% String select=request.getSession().getAttribute("select").toString();%>
<%List messagesList= (List)request.getAttribute("messagesList");
int length= messagesList.size();
System.out.println(length);
MsgList m= null;
for(int i=0;i<length;i++){
	m=(MsgList)messagesList.get(i);
	
%>


<table>
<%  select=request.getSession().getAttribute("select").toString();%>
<tr bgcolor="<%= select.equals("Patient")?"pink":"#cccccc" %>">

<td><%=m.getId()%><%=m.getFirstName() %><%=m.getLastName() %><br><%=m.getDate() %></td>
<% if(select.equals("Patient")){%>

<td><a href="MsgServlet?action=sendMessage&doctorId=<%=m.getId()%>"/><%=m.getMsgBox() %></td>
</tr>
<%}else{ %>
<td><a href="MsgServlet?action=sendMessage&patientId=<%=m.getId()%>"/><%=m.getMsgBox() %></td>

<%} %>

<%} %>

</table>
</form>
</body>
</html>