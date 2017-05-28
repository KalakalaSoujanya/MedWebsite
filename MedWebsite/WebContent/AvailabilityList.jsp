<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="java.util.List,java.util.*,com.medical.servlet.AppointmentSlots"%> 
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
<%String  patientId=request.getSession().getAttribute("patientId").toString(); %>

<% String doctorId=request.getParameter("doctorId"); %>

<%List fullSlots= (List) request.getAttribute("fullSlots");%>
  
<%String date= request.getAttribute("date").toString();%>

<form method="post" action="Patient?action=bookingSlots&doctorId=<%= doctorId %>">

<table Align="center">
<tr><td><b>Date Selected: <%=date %></b></td></tr>
<tr><td>&nbsp;&nbsp;</td></tr>
<tr><td><b>AvailableSlots</b></td>

<td><% fullSlots= (List) request.getAttribute("fullSlots");%>
<select name="slotNo">
 <c:forEach var="slotNo" items="${fullSlots}">
  <option> <c:out value="${slotNo}"
  />

   </option>
     </c:forEach></select></td>
<td><input type="submit"  name="submit" value="Book"></td></tr>
<tr><td><input type="hidden" name="date" value=<%= date %>></td></tr>

</table>

 </form>
 
 
 
</body>
</html>