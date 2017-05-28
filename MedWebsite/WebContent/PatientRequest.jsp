<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List,com.medical.servlet.Patient"%> 
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
</table width="40%" >
<br><br>
<form method="post" action="">
<% String message=(String)request.getAttribute("message"); %>
<%= ((message!=null)?message:"") %>
<table width="50%" align="center" bgcolor="#cccccc" border="0" cellpadding="0" cellspacing="0">
<tr bgcolor="Pink">
<th>PatientId</th>
<th>PatientLastName</th>
<th>PatientFirstName</th>
<th>&nbsp;</th>
<th>&nbsp;</th>
</tr>
<%
List patientReqList= (List)request.getAttribute("patientReqList");
int length=patientReqList.size();
Patient p= null;
for(int i=0;i<length;i++){
	p=(Patient)patientReqList.get(i);
	%>
	<tr  bgcolor="#cccccc" >
	<td width="10%"><%=p.getPatientId() %></a></td>
	<td width="30%"><%=p.getLastName() %></td>
	<td width="30%"><%=p.getFirstName() %></td>
	<td width="15%"align= "center"><a href="Doctor?action=Approve&patientId=<%=p.getPatientId()%>">Approve</a></td>
	<td  width="15%" align= "center"><a href="Doctor?action=denied&patientId=<%=p.getPatientId()%>">Denied</a></td></tr>
	<%} %>	
</table>
</form>

</body>
</html>