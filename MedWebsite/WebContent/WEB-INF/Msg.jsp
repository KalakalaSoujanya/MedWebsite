<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.medical.servlet.Message"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%String doctorId=request.getParameter("doctorId"); %>
<%String message=(String)request.getAttribute("message"); %>
<form method="post" >
<%
List Messages= (List)request.getAttribute("Messages");
int length= Messages.size();
System.out.println(length);
Message m= null;
for(int i=0;i<length;i++){
	m=(Message)Messages.get(i);
%>
<table>
<tr bgcolor="pink">
<td><%=m.getSender() %><br><%=m.getDate() %></td>
<td><%=m.getMsgBox() %></td>
</tr>

<%} %>	
</table>
</form>
<form method="post" action="MsgServlet?action=createMessage&doctorId=<%=doctorId %>">
<table>
<tr><td><input type="text" name="msgBox" /></td>

<td><input type="submit" name="submit" value="Send"/></td></tr>

</table>
</form>
</body>
</html>