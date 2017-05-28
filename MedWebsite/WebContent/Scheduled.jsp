 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@ page import="java.util.List,java.util.ArrayList,com.medical.servlet.ScheduledAppointment"%> 
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
<% String select=request.getSession().getAttribute("select").toString();%> 

 <table width="65%" align="center" bgcolor="#cccccc" border="0" cellpadding="0" cellspacing="0">
 <tr bgcolor="pink"><th>Doctor FirstName</th>
 <th>Doctor LastName</th>
 <th>Date Select</th>
 <th>Slot Number</th></tr>
 <%List scheduledList=(List)request.getAttribute("scheduledList");
int length=scheduledList.size();
System.out.println(length);
ScheduledAppointment sa=null;
for(int i=0;i<length;i++){
	sa=(ScheduledAppointment)scheduledList.get(i);
%>
 
 <tr bgcolor="#cccccc"><td  align="center"><%=sa.getFirstName() %></td>
 <td  align="center"><%=sa.getLastName() %></td>
 <td  align="center"><%=sa.getDateSelect() %></td>
<td  align="center"><%= sa.getSlotNoIndex()%></td></tr>
<%} %>
 </table>


</body>
</html>