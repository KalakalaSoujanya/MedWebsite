<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medhisive</title>
<style>
.drop{
text-align:center;
display:block;
position:relative;
}
.drop2{

background-color:black;
color:white;
padding:8px;
border:none;
cursor:pointer;
}
.dropdown2{
position:relative;
display:inline-block;
}
.dropdown2content {
		
   	display:none;
    position:absolute;
    background-color:#f9f9f9;
   min-width:160px;
    box-shadow:0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index:1;
   }
.dropdown2content  a {
color:black;
padding:12px 16px;
text-decoration:none;
display:block;
}
.dropdown2content a:hover{
background-color:#f1f1f1;
}
.dropdown2:hover .dropdown2content {
    display:block;
}

.dropdown2:hover .drop2 {
    background-color:#3e8e41;
}
.pictures{
margin:0;

}
.pictures p{
margin:0;
background-color:#000000;}
.pictures img{
float:center;
padding:25px 250px 25px 300px;
width:60%;
height:40%;
}
</style>
</head>

<body>

<jsp:include page="Header.jsp"></jsp:include>
<table width="100%" height="20px" bgcolor="	#808080">
<tr><td>&nbsp;&nbsp;</td></tr>
</table>
<table bgcolor="#cccccc" width=100% height=40px;>
<tr><td><button class="drop2" style="float:right; margin:0px 20px 0px 15px;"><a style="color:white" href="MedLogin.jsp">Login</a></button>
<div class= "dropdown2" style="float:right;">
<button class="drop2" >Register</button>
<div class="dropdown2content">
<a href="PatientReg.jsp">PatientType</a>
<a href="DoctorReg.jsp">DoctorType</a>
</div>
</div></td>

<td>
</td>
</tr>
</table>
<div  class="pictures" >
<p><img src="Images/MedicalWebsite1.jpg" alt="image not found"/></p>

</body>
</html>