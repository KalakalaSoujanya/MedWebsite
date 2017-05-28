package com.medical.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginHelper {
	public String login(String username, String password, String select){
		 String msg= null;
		 String _password=null;
		  try{  
				//step1 load the driver class  
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				  
				//step2 create  the connection object  
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				String query=null;
				if(select.equals("Patient")){
				query="select password from PATIENT where  Username='"+username+"'";	
				}else if(select.equals("Doctor")){
				     query="select password from Doctor where  Username='"+username+"'";
					}
				ResultSet rs=stmt.executeQuery(query);
				  
				//step4 execute query  
				
				while(rs.next()){  
					_password=rs.getString(1);
					}
		  //step5 close the connection object  
				con.close();  
			
				if((_password!=null)&&_password.equals(password)){
					msg= "success";
				}else {
					msg= "failure";
				}
				
				}catch(Exception e){ System.out.println(e);}
				finally{
					return msg;
				}
	}
}
				
			
		  
		  

	



