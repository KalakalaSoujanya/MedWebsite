
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page import="java.util.List,java.util.*,com.medical.servlet.AppointmentSlots"%> 
  
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/></script>
<script>
$(function(){
	
	$("#datepicker" ).datepicker({dateFormat: 'yy-mm-dd', minDate:new Date}).val();
	
	showButtonPanel:true
	
});
</script>
</head>
<body bgcolor="#ffffff">
<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<tr><td>&nbsp;&nbsp;</td></tr>
</table>
</br></br></br>





<%String patientId=request.getSession().getAttribute("patientId").toString(); %>
<% String doctorId=request.getParameter("doctorId"); %>
<%List fullSlots=(List)request.getAttribute("fullSlots"); %>

<%-- <%String date=""; %> --%>
<%-- <%request.setAttribute("date",date); %> --%>


<form method="post" action="Patient?action=slotList&doctorId=<%= doctorId %>">

<center>
<h3>Make an Appointment with the Doctor</h3>
<br><br><br>




<p>Appointment Date:<input type="text" name="date" id="datepicker"></p>

<input type="submit" name="submit" value="Availability">

</center>
</form>



  


</body>
</html>