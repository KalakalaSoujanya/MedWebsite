<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List,com.medical.servlet.Patient"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="#ffffff">
<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<tr><td>&nbsp;&nbsp;</td></tr>
</table width="40%" >
<br><br><br><br>
<form method="post" action="">

<table width="65%" align="center" bgcolor="#cccccc" border="0" cellpadding="0" cellspacing="0">
<tr bgcolor="pink">
<th>PatientId</th>
<th>LastName</th>
<th>FirstName</th>
<th>Send Message</th>
<th>Enter</th>
<th>View</th>
<th>Send </th>
</tr>
<%
List currentPatientList= (List)request.getAttribute("currentPatientList");
int length=currentPatientList.size();
Patient p= null;
for(int i=0;i<length;i++){
	p=(Patient)currentPatientList.get(i);
	%>
	<tr  bgcolor="#cccccc">
	<td width="10%" align="center"><%=p.getPatientId() %></a></td>
	<td width="10%" align= "center"><%=p.getFirstName() %></td>
	<td width="10%" align= "center"><%=p.getLastName() %></td>
	<td width="10%" algin="center" ><a style="color:blue" href="MsgServlet?action=sendMessage&patientId=<%=p.getPatientId()%>" >Message </a></td>
	<td width="15%" align="center"><a style="color:blue" href="Doctor?action=Prescription&patientId=<%=p.getPatientId()%>"> Test Prescription</a></td>
	<td  width="15%" align= "center"><a  style="color:blue"href="Doctor?action=PrescriptionList&patientId=<%=p.getPatientId()%>">Test Prescriptions</a></td>
	<td  width="15%" align= "center"><a style="color:blue" href="Doctor?action=resultForm&patientId=<%=p.getPatientId()%>"> Test Results</a></td>
	</tr>

	<%} %>	
</table>
</form>

</body>
</html>

</body>
</html>