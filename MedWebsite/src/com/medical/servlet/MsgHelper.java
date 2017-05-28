package com.medical.servlet;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;




public class MsgHelper {
	
public boolean createMessage(int patientId,int doctorId,String msgBox,String sender){
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
					   
					   ResultSet rt=stmt.executeQuery("select max (MSGID) from Message");
						int id=0;
						while(rt.next()){  
						id= rt.getInt(1);
						
						}
					  String query="insert into MESSAGE values("+(id+1)+","+patientId+","+doctorId+",'"+sender+"','"+date+"','"+msgBox+"','u')";
					  boolean rs=stmt.execute(query);
					  con.commit();
					 stmt.close();
					con.close(); 
					
					System.out.println("Inserted");
		}catch(Exception e) {e.printStackTrace();} 
		return true;
		}


public List getMessagesList(String patientId,String doctorId){
	List<Message> list= new ArrayList<Message>();
		try{  	//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step2
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			
			Statement stmt=con.createStatement();  
			
			
			
			String query="Select SENDER,SENTTIME,MSGBOX FROM Message where patientId="+patientId+" and doctorId="+doctorId;
			System.out.println(query);
			ResultSet rt=stmt.executeQuery(query );
			
			Message m=null;
			while(rt.next()){  
				m= new Message(rt.getString(1),rt.getString(2),rt.getString(3));
				list.add(m);
				
				} 
			
			stmt.close();
			con.close();
			}catch(Exception e){ System.out.println(e);}
			finally{
				return list;
			}
			}
public List getPatientMsgList(String patientId){
	List<MsgList> list= new ArrayList<MsgList>();
		try{  	//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step2
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			
			Statement stmt=con.createStatement();  
			
			String query="Select DOCTOR.DOCTORID,DOCTOR.FIRSTNAME,DOCTOR.LASTNAME, MESSAGE.SENTTIME,MESSAGE.MSGBOX FROM MESSAGE INNER JOIN DOCTOR ON MESSAGE.DOCTORID=DOCTOR.DOCTORID AND sender='D'and  MESSAGE.patientId="+patientId+ "ORDER BY SENTTIME DESC";
			System.out.println(query);
			ResultSet rt=stmt.executeQuery(query );
			
			MsgList m=null;
			while(rt.next()){  
				m= new MsgList(rt.getInt(1),rt.getString(2),rt.getString(3),rt.getString(4),rt.getString(5));
				list.add(m);
				
				} 
			
			stmt.close();
			con.close();
			}catch(Exception e){ System.out.println(e);}
			finally{
				return list;
			}
			}

public List getDoctorMsgList(String doctorId){
	List<MsgList> list= new ArrayList<MsgList>();
		try{  	//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step2
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			
			Statement stmt=con.createStatement();  
			
			
			
			String query="Select  PATIENT.PATIENTID,PATIENT.FIRSTNAME,PATIENT.LASTNAME,MESSAGE.SENTTIME,MESSAGE.MSGBOX FROM MESSAGE INNER JOIN PATIENT ON MESSAGE.PATIENTID=PATIENT.PATIENTID AND sender='P' and MESSAGE.DOCTORID="+doctorId+ "  ORDER BY SENTTIME DESC" ;
			System.out.println(query);
			ResultSet rt=stmt.executeQuery(query );
			
			MsgList m=null;
			while(rt.next()){  
				m= new MsgList(rt.getInt(1),rt.getString(2),rt.getString(3),rt.getString(4),rt.getString(5));
				list.add(m);
				
				} 
			
			stmt.close();
			con.close();
			}catch(Exception e){ System.out.println(e);}
			finally{
				return list;
			}
			}
/*public int getDoctorDetails(String firstName,String lastName){
	int id=0;
	
		try{  	//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step2
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			
			Statement stmt=con.createStatement();  
			
			
			
			ResultSet rt=stmt.executeQuery("Select DOCTORID FROM DOCTOR WHERE firstName='"+firstName+"'and lastName='"+lastName+"'");
			
			while(rt.next()){  
				id= rt.getInt(1);
															
				}
				//step5 close the connection object  
				con.close(); 
															
				
				}catch(Exception e) {System.out.println(e);} 
				finally{
					return id;
				}
				}*/
/*public int getPatientDetails(String firstName,String lastName){
	int id=0;
	
		try{  	//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step2
			Connection con=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			
			Statement stmt=con.createStatement();  
			
			
			
			ResultSet rt=stmt.executeQuery("Select PATIENTID FROM PATIENT WHERE firstName='"+firstName+"'and lastName='"+lastName+"'");
			
			while(rt.next()){  
				id= rt.getInt(1);
															
				}
				//step5 close the connection object  
				con.close(); 
															
				
				}catch(Exception e) {System.out.println(e);} 
				finally{
					return id;
				}
				}
			
			*/
			
			
			
			

}


