<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.List,com.medical.servlet.Patient,com.medical.servlet.Doctor,com.medical.servlet.Test"%>
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
<table width="65%" align="center" bgcolor="#cccccc" border="0" cellpadding="0" cellspacing="0">
 <tr bgcolor="pink">
 <th>TestId</th>
 <th>Date</th>
 <th>patientId</th>
 <th>ViewResults</th>
 </tr>
 
 <%List pList=(List)request.getAttribute("pList");
int length=pList.size();
System.out.println(length);
Test t=null;
for(int i=0;i<length;i++){
	t=(Test)pList.get(i);
%>
 
 <tr bgcolor="#cccccc">
 <td align="center"><a style="color:blue" href="Doctor?action=PrescriptionForms&testId=<%=t.getTestId()%>"><%=t.getTestId() %></a></td>
 <td  align="center"><%=t.getD2()%></td>
 <td  align="center"><%=t.getPatientId() %></td>
<td  align="center"><a  style="color:blue" href="Doctor?action=viewResults&testId=<%=t.getTestId()%>&patientId=<%=t.getPatientId()%>">ViewResults</a></td></tr>
<%} %>
 </table>
</body>
</html>