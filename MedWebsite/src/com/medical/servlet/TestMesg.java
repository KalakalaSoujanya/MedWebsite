package com.medical.servlet;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class TestMesg {
	

	public static void main(String[] args) {
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb"); 
			System.out.println("Inserted");
			con.setAutoCommit(false);
					  Statement stmt=con.createStatement();  
					   Date d=new Date();
					   SimpleDateFormat f=new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss");
					   String date=f.format(d);
					  
					  String query="insert into MESSAGE values(5,1,1,'p','"+date+"','HelloWorld','u')";
					  boolean rs=stmt.execute(query);
					  con.commit();
					 stmt.close();
					con.close(); 
					
					System.out.println("Inserted");
		}catch(Exception e) {e.printStackTrace();} 
		
		}

	}
