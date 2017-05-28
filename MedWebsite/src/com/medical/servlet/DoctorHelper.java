package com.medical.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DoctorHelper {
public boolean createDoctor(Doctor d){
	try{
		//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
				  
				//step3 create the statement object  
				Statement stmt=con.createStatement();  
				  
				//step4 execute query  
				ResultSet rt=stmt.executeQuery("select max (doctorId) from Doctor");
				int id=0;
				while(rt.next()){  
				id= rt.getInt(1);
				
				}
				String query="insert into Doctor values("+(id+1)+",'"+ d.getFirstName()+"','"+d.getLastName()+"','"+d.getTitle()+"','"+d.getSpeciality()+"','"+d.getEmailId()+"','"+d.getOfficeStreet()+"','"+d.getAddress()+"','"+d.getOfficeCity()+"','"+d.getOfficeState()+"','"+d.getUserName()+"','"+d.getPassword()+"')";
				int rs= stmt.executeUpdate(query);
				System.out.println(query);
				//step5 close the connection object  
				con.close(); 
				return true;
	}catch(Exception e) {System.out.println(e);} 
	return false;
}
public List getDoctors(){
	List<Doctor> list= new ArrayList<Doctor>();
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("Select * FROM Doctor");
			
			
			Doctor e= null;
			while(rs.next()){  
			e= new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
			list.add(e);
			}//step5 close the connection object  
			con.close();  
			}catch(Exception e){ System.out.println(e);}
			finally{
				return list;
			}
}
		
		public List searchDoctors(String search){
			List<Doctor> list= new ArrayList<Doctor>();
				try{  
					//step1 load the driver class  
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					  
					//step2 create  the connection object  
					Connection con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
					  
					//step3 create the statement object  
					Statement stmt=con.createStatement(); 
					if(search==null){
						search="";
					}
					
					//step4 execute query  
					ResultSet rs=stmt.executeQuery("Select doctorId,FIRSTNAME,LASTNAME,TITLE,SPECIALITY from DOCTOR WHERE UPPER(FIRSTNAME) like '%"+search.toUpperCase()+"%' or  UPPER(SPECIALITY)like '%"+search.toUpperCase()+"%'");
					System.out.println("Select * FROM Doctor where FIRSTNAME like '%"+search+"%'");
					
					
					Doctor e= null;
					while(rs.next()){  
					e= new Doctor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					list.add(e);
					}
					con.close();  
					}catch(Exception e){ System.out.println(e);}
					finally{
						return list;
					}
}
		public int getDoctorByuserName(String username){
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
			ResultSet rt=stmt.executeQuery("select doctorId from Doctor where username='"+username+"'");
			
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
		public boolean patientReqStatus(String patientId, String doctorId){
			
			try{
				//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
										//Step2
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			
														  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
													  
			//step4 execute query 
			String query="update DoctorPatient set status='A' where status='R' and patientId="+patientId+ " and doctorId="+doctorId;
			int rt=stmt.executeUpdate(query);
			con.close(); 
				return true;										
			
			}catch(Exception e) {
				System.out.println(e);
			return false;
			}
			
			}
		
public boolean patientRequestStatus(String patientId, String doctorId){
			
			try{
				//Step1
			Class.forName("oracle.jdbc.driver.OracleDriver");
										//Step2
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			
														  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
													  
			//step4 execute query 
			String query="update DoctorPatient set status='D' where status='R' and patientId="+patientId+ " and doctorId="+doctorId;
			int rt=stmt.executeUpdate(query);
			con.close(); 
				return true;										
			
			}catch(Exception e) {
				System.out.println(e);
			return false;
			}
			
			}

public List currentPatientList(String patientId, String doctorId){
	List<Patient> list= new ArrayList<Patient>();
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			
			//step4 execute query  
			ResultSet rt=stmt.executeQuery("Select PATIENT.PATIENTID ,PATIENT.LASTNAME,PATIENT.FIRSTNAME FROM PATIENT INNER JOIN DOCTORPATIENT ON DOCTORPATIENT.PATIENTID=PATIENT.PATIENTID and DOCTORPATIENT.Status='A' and DOCTORPATIENT.DOCTORID="+doctorId);
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

public boolean createPrescriptionDetails(int testId,java.util.Date d2,String testName,int doctorId,int patientId,String doctorNote){
	boolean result=false;
	try{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
		 con.setAutoCommit(false);
				  
				
		 PreparedStatement stmt=null;
		  ResultSet rs = null;
		  java.sql.Date d3=new java.sql.Date(d2.getTime());
		  stmt = con.prepareStatement("select max (testId) from Test");
		  
		  ResultSet rt=stmt.executeQuery();
			int id=0;
			while(rt.next()){  
			id= rt.getInt(1);
			
			}
		  
	        
	            String query = "insert into Test values(?,?,?,?,?,?)";
	            stmt = con.prepareStatement(query);
	            stmt.setInt(1,id+1);
	            stmt.setDate(2,d3);  
	    		stmt.setString(3,testName );
	    		stmt.setInt(4,doctorId);
	    		stmt.setInt(5, patientId);
	    		stmt.setString(6,doctorNote);
	            stmt.executeUpdate();
	           con.close(); 
	        	return result=true;
	        	}catch(Exception e) {e.printStackTrace();} 
	        	finally{
	        		return result;
	        	}
	        }
public List getPrescriptionList(int doctorId,int patientId){
	
	List<Test> list= new ArrayList<Test>();
	try{  	//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
		
		Statement stmt=con.createStatement();  
		
		
		
		String query="Select TESTID,TESTDATE,PATIENTID FROM TEST   WHERE TEST.DOCTORID="+doctorId+"and patientId="+patientId;
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

public Test getFullPrescription(int testId){
	
      Test t=null;
	try{  	//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
		
		Statement stmt=con.createStatement();  
		
		
		
		String query="Select * from Test where testId="+testId;
		System.out.println(query);
		ResultSet rt=stmt.executeQuery(query );
		
		
		while(rt.next()){  
			 t= new Test(rt.getInt(1),rt.getDate(2),rt.getString(3),rt.getInt(4),rt.getInt(5),rt.getString(6));
		}			
		stmt.close();
		con.close();
		}catch(Exception e){ System.out.println(e);}
		finally{
			return t;
		}
  }
public boolean createResultDetails(int resultId,int testId,java.util.Date d2,String normalRange,String actualResult,String testResultsNote){
	boolean result=false;
	try{
		//Step1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Step2
		Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:@localhost:1521:xe","MedicalWeb","MedicalWeb");  
		 con.setAutoCommit(false);
				  
				//step3 create the statement object
		 PreparedStatement stmt=null;
		  ResultSet rs = null;
		  java.sql.Date d3=new java.sql.Date(d2.getTime());
		  stmt = con.prepareStatement("select max (resultId) from TestResult");
		  
		  ResultSet rt=stmt.executeQuery();
			int id=0;
			while(rt.next()){  
			id= rt.getInt(1);
			
			}
		       String query = "insert into TestResult values(?,?,?,?,?,?)";
	            stmt = con.prepareStatement(query);
	            stmt.setInt(1,id+1);
	            stmt.setInt(2, testId);
	            stmt.setDate(3,d3);  
	    		stmt.setString(4,normalRange );
	    		stmt.setString(5,actualResult);
	    		stmt.setString(6, testResultsNote);
	    		
	            stmt.executeUpdate();
	            con.close(); 
	        	return result=true;
	        	}catch(Exception e) {e.printStackTrace();} 
	        	finally{
	        		return result;
	        	}
	        }
public TestResult viewResult(int testId){
	
    TestResult m=null;
	try{  	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
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
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		
		
		
	
	

