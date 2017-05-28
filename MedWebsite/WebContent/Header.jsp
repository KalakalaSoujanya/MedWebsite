<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medhisive</title>
<style>
.header{
position:relative;
}
.header img{

display:inline;
float:center;
}
.header h1{

padding: 25px 20px 100px 40px;
display:inline;

}
</style>
</head>
<%String username=(String)request.getSession().getAttribute("username"); %>
<body class="header" >
<table width="100%" height="150px" bgcolor="pink">
<tr><td  align="center" color="white"><img src="Images/MedicalWebsite.png" alt="image not found"/><h1><b>Medhisive</b></h1></b></td></tr>
<tr><td>&nbsp;</td>
<%if(username!=null){ %> 
<tr><td style="color:blue;float:right; margin-right:30px;">welcome <%=username %></td></tr>
<tr><td style="color:blue; float:right;margin-right:45px;"><a href="Patient?action=logout">Logout</a></td></tr>

</table>
<%} %>

</body>
</html>