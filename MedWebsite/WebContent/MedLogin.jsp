<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body bgcolor="#ffffff">
<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<tr><td>&nbsp;&nbsp;</td></tr>
</table>
</br></br></br>
<%String var=(String)request.getAttribute("error"); %>


<form  method="post" action="LoginServlet">
<font color="red"><%=((var!=null)?var:"")%></font>
<table align="center" width="20%" border="0">
<tr><td align="center" colspan="3"><h2>Login</h2></td></tr>
<tr><td>&nbsp;&nbsp;</td></tr>
<tr><td align="center" colspan="3"><b>Username&nbsp;&nbsp;</b><input type="text" name="username"/></td></tr>
<tr><td>&nbsp;&nbsp;</td></tr>
<tr><td align="center" colspan="3"><b>Password&nbsp;&nbsp;&nbsp;</b><input type="password" name="Password"/></td></tr>
<tr><td>&nbsp;&nbsp;</td></tr>
<tr><td align="center">
<select name="select">
  <option value="Patient">Patient</option>
  <option value="Doctor">Doctor</option>
 </select>
<tr><td>&nbsp;&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;</td></tr>
<tr><td align="center" colspan="3"><input type="submit" name="Submit"/></td></tr>
</table>
</form>

</body>
</html>