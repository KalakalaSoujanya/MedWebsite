package com.medical.servlet;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.medical.servlet.*;

public class PatientHelper {
	public boolean createPatient(Patient p){
		try{
			//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step2
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
					  
					//step3 create the statement object  
					Statement stmt=con.createStatement();  
					  
					//step4 execute query  
					ResultSet rt=stmt.executeQuery("select max (patientId) from Patient");
					int id=0;
					while(rt.next()){  
					id= rt.getInt(1);
					
					}
					
					String query="insert into Patient values("+(id+1)+",'"+ p.getFirstName()+"','"+p.getLastName()+"','"+p.getEmailId()+"','"+p.getUsername()+"','"+p.getPassword()+"')";
					int rs= stmt.executeUpdate(query);
					System.out.println(query);
					//step5 close the connection object  
					con.close(); 
					
		return true;
		}catch(Exception e) {System.out.println(e);} 
		return false;
		}
	public boolean sendRequest(String patientId, String doctorId){
		try{
			//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Step2
			Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
					  
					//step3 create the statement object  
					Statement stmt=con.createStatement();  
					  
					//step4 execute query 
					
					
					String query="insert into DoctorPatient values('"+patientId+"','"+doctorId+"','R')";
					int rs=stmt.executeUpdate(query);
					
					
					//System.out.println(query);
					//step5 close the connection object  
					con.close(); 
		return true;
		}catch(Exception e) {System.out.println(e);} 
		return false;
		}
	public boolean requestSent(String doctorId, String patientId){
		boolean present=false;
		try{
			//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
									//Step2
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
													  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
												  
		//step4 execute query  
		ResultSet rt=stmt.executeQuery("select count(*) from DOCTORPATIENT where patientId="+patientId+"  and doctorId= "+doctorId+" and (status ='R' OR status='A' OR status='D')");
		int count=0;
		
		while(rt.next()){  
		count= rt.getInt(1);
													
		}
		if(count>0){
			present=true;
		}
		System.out.println(present);
		//step5 close the connection object  
		con.close(); 
		}catch(Exception e) {System.out.println(e);} 
		finally{
			return present ;
			
		}
		
		
		}
	public int getPatientByuserName(String username){
		int id=0;
		try{
			//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
									//Step2
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
													  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
												  
		//step4 execute query  
		ResultSet rt=stmt.executeQuery("select patientId from Patient where username='"+username+"'");
		
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
	public List requestList(String doctorId){
		List<Patient> list=new ArrayList<Patient>();
		try{
			//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
									//Step2
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
													  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
												  
		//step4 execute query  
		String query="select PATIENT.PATIENTID, PATIENT.FIRSTNAME,PATIENT.LASTNAME FROM DOCTORPATIENT INNER JOIN PATIENT ON DOCTORPATIENT.PATIENTID=PATIENT.PATIENTID and DOCTORPATIENT.Status='R' and DOCTORPATIENT.DOCTORID="+doctorId;
		ResultSet rt=stmt.executeQuery(query);
		
		Patient p=null;
		
		while(rt.next()){  
		p= new Patient(rt.getInt(1),rt.getString(2),rt.getString(3));
		list.add(p)	;										
		}
		
		//step5 close the connection object  
		con.close(); 
		}catch(Exception e) {System.out.println(e);} 
		finally{
			return list ;
			
		}
		
		}
	public List myDoctorsList(String patientId){
		List<Doctor> list=new ArrayList<Doctor>();
		try{
			//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
									//Step2
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
													  
		//step3 create the statement object  
		Statement stmt=con.createStatement();  
												  
		//step4 execute query  
		String query="Select DOCTOR.DOCTORID,DOCTOR.FIRSTNAME,DOCTOR.LASTNAME,DOCTOR.TITLE,DOCTOR.SPECIALITY from DOCTORPATIENT INNER JOIN DOCTOR ON DOCTORPATIENT.DOCTORID=DOCTOR.DOCTORID and status='A' and patientId="+patientId;
		ResultSet rs=stmt.executeQuery(query);
		
		Doctor e= null;
		while(rs.next()){  
		e= new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
		list.add(e);
		}
		
		//step5 close the connection object  
		con.close(); 
		}catch(Exception e) {System.out.println(e);} 
		finally{
			return list ;
			
		}
		
		}
	public List getFilledSlots(java.util.Date d1,int doctorId){
		
		List<Integer> list= new ArrayList();
		
	
		try{
			//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
									//Step2
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
													  
		//step3 create the statement object  
		PreparedStatement stmt = con.prepareStatement("SELECT SLOTNUMBER FROM APPOINTMENT  WHERE DATESELECT=? AND DOCTORID=? " );
		
		
		java.sql.Date d2=new java.sql.Date(d1.getTime());
		stmt.setDate(1, d2);
		stmt.setInt(2, doctorId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()){
			
		int i=rs.getInt("SLOTNUMBER");
			AppointmentTable at=new AppointmentTable(i);
			list.add(i);
		}
		
		
		
		con.close();
		}catch(Exception e){ System.out.println(e);}
		
		finally{		
		return list ;
		
	}
		
}
public boolean bookingSlots(java.util.Date d1,int slot,int doctorId,int patientId){
		boolean result=false;
	try{
			//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
									//Step2
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
													  
		//step3 create the statement object  
		PreparedStatement stmt=null;
		String query="INSERT INTO APPOINTMENT"+"(DATESELECT,SLOTNUMBER,DOCTORID,PATIENTID) VALUES"+"(?,?,?,?)";
		
		
		
		stmt=con.prepareStatement(query);
		java.sql.Date d2=new java.sql.Date(d1.getTime());
		stmt.setDate(1,d2);
		stmt.setInt(2,slot);
		stmt.setInt(3,doctorId);
		stmt.setInt(4, patientId);
		
		stmt.executeUpdate();
		result=true;
		System.out.println(result);
	
		con.close();
		}catch(Exception e){ System.out.println(e);}
		
		finally{		
		return result  ;
	}
}
public List patScheduledSlots(int patientId){
	
	List<ScheduledAppointment> list= new ArrayList<ScheduledAppointment>();
	try{  	//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
		
		Statement stmt=con.createStatement();  
		
		
		
		String query="Select DOCTOR.FIRSTNAME,DOCTOR.LASTNAME,DATESELECT,SLOTNUMBER FROM APPOINTMENT INNER JOIN DOCTOR ON APPOINTMENT.DOCTORID=DOCTOR.DOCTORID AND APPOINTMENT.PATIENTID="+patientId+" ORDER BY DATESELECT DESC" ;
		System.out.println(query);
		ResultSet rt=stmt.executeQuery(query );
		
		ScheduledAppointment sa=null;
		while(rt.next()){  
			sa= new ScheduledAppointment(rt.getString(1),rt.getString(2),rt.getDate(3),rt.getInt(4));
			list.add(sa);
			
			} 
		
		stmt.close();
		con.close();
		}catch(Exception e){ System.out.println(e);}
		finally{
			return list;
		}
		}
	
public List docScheduledSlots(int doctorId){
	
	List<ScheduledAppointment> list= new ArrayList<ScheduledAppointment>();
	try{  	//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
		
		Statement stmt=con.createStatement();  
		
		
		
		String query="Select PATIENT.FIRSTNAME,PATIENT.LASTNAME,DATESELECT,SLOTNUMBER FROM APPOINTMENT INNER JOIN PATIENT ON APPOINTMENT.PATIENTID=PATIENT.PATIENTID AND APPOINTMENT.DOCTORID="+doctorId+" ORDER BY DATESELECT,SLOTNUMBER DESC " ;
		System.out.println(query);
		ResultSet rt=stmt.executeQuery(query );
		
		ScheduledAppointment sa=null;
		while(rt.next()){  
			sa= new ScheduledAppointment(rt.getString(1),rt.getString(2),rt.getDate(3),rt.getInt(4));
			list.add(sa);
			
			} 
		
		stmt.close();
		con.close();
		}catch(Exception e){ System.out.println(e);}
		finally{
			return list;
		}
		}public List getTestResultsList(int patientId,int doctorId){
			
			List<Test> list= new ArrayList<Test>();
			try{  	//Step1
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Step2
				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
				
				Statement stmt=con.createStatement();  
				
				
				
				String query="Select TESTID,TESTDATE,DOCTORID FROM TEST   WHERE TEST.DOCTORID="+doctorId+"and patientId="+patientId;
				System.out.println(query);
				ResultSet rt=stmt.executeQuery(query );
				
				Test t=null;
				while(rt.next()){  
					t= new Test(rt.getInt(1),rt.getDate(2),rt.getInt(3));
					list.add(t);
					
					} 
				
				stmt.close();
				con.close();
				}catch(Exception e){ System.out.println(e);}
				finally{
					return list;
				}
		  }
		public TestResult viewResult(int testId){
			
		    TestResult m=null;
			try{  	//Step1
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//Step2
				Connection con=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
				
				Statement stmt=con.createStatement();  
				
				
				
				String query="Select * from TestResult where testId="+testId;
				System.out.println(query);
				ResultSet rt=stmt.executeQuery(query );
				
				
				while(rt.next()){  
					 m= new TestResult(rt.getInt(1), rt.getInt(2),rt.getDate(3),rt.getString(4),rt.getString(5),rt.getString(6));
				}	
		        
				stmt.close();
				con.close();
				}catch(Exception e){ System.out.println(e);}
				finally{
					return m;
				}

		
}
}

	
	
	


