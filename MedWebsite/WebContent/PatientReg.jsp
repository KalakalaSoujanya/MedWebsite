<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form method="post" action="Patient?action=create">
<table width="30%" bgcolor="#808080" align="center">
<tr><td align="center" colspan="3"><h2>Registration</h2></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;</td><td><b>FirstName</b></td><td><input type="text" name="firstName" required /></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>LastName</b></td><td><input type="text" name="lastName" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>EmailId</b></td><td><input type="text" name="emailId" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b>UserName</b></td><td><input type="text" name="userName" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td>&nbsp;</td><td><b> Password</b></td><td><input type="password" name="password" required/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>
<tr><td align="center" colspan="3"><input type="submit" name="Submit"/></td></tr>
<tr><td align="center" colspan="3">&nbsp;</td></tr>


</table>
</form>

</body>
</html>