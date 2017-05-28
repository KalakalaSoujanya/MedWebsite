package com.medical.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/Doctor")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=null;
		
		DoctorHelper helper= new DoctorHelper();
		String action= request.getParameter("action");
		if(action.equals("list")){
		List doctors= (List)helper.getDoctors();
			request.setAttribute("doctors", doctors);
		request.getRequestDispatcher("DoctorsList.jsp").forward(request,response);
		}else if(action.equals("create")){
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String title=request.getParameter("title");
			String speciality=request.getParameter("speciality");
			String emailId=request.getParameter("emailId");
			String officeStreet=request.getParameter("officeStreet");
			String address=request.getParameter("address");
			String officeCity=request.getParameter("officeCity");
			String officeState=request.getParameter("officeState");
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			Doctor d= new Doctor(0,firstName,lastName,title,speciality,emailId,officeStreet,address,officeCity,officeState,userName,password);
			boolean status=helper.createDoctor(d);
			
			if(status){
				request.getRequestDispatcher("MedLogin.jsp").forward(request, response);
			}
	
		
	}else if(action.equals("search")){
			String search=request.getParameter("search");
		List doctors= (List)helper.searchDoctors(search);
		System.out.println(doctors);
		request.setAttribute("doctors",doctors);
		request.getRequestDispatcher("DoctorsList.jsp").forward(request,response);
		
	}else if(action.equals("Approve")){
		String patientId=request.getParameter("patientId");
		String doctorId=request.getSession().getAttribute("doctorId").toString();
		boolean status=helper.patientReqStatus(patientId,doctorId);
		if(status){
			System.out.println(status);
	     request.setAttribute("message", "Approved");
		}
		request.getRequestDispatcher("Patient?action=doctorDecision").forward(request, response);
		}
	
	else if(action.equals("denied")){
		String patientId=request.getParameter("patientId");
		String doctorId=request.getSession().getAttribute("doctorId").toString();
		boolean status=helper.patientRequestStatus(patientId,doctorId);
		System.out.println(status);
		if(status){
			request.setAttribute("message", "Denied");
		}
			request.getRequestDispatcher("Patient?action=doctorDecision").forward(request, response);
		}
	else if(action.equals("currentPatientList")){
		String patientId=request.getParameter("patientId");
		String doctorId=request.getSession().getAttribute("doctorId").toString();
		List currentPatientList=helper.currentPatientList(patientId,doctorId);
		request.setAttribute("currentPatientList",currentPatientList);
		request.getRequestDispatcher("CurrentPatientList.jsp").forward(request, response);
	   		
	} else if(action.equals("Prescription")){
	   			String doctorId= request.getSession().getAttribute("doctorId").toString();
	   	         String patientId=request.getParameter("patientId");
	   	      request.setAttribute("patientId", patientId);
	   	    request.getRequestDispatcher("TestForm.jsp").forward(request,response);
	   			}
	else if (action.equals("insertPrescriptionDetails")){
		
		String date=request.getParameter("date");
		
		System.out.println(date);
		
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d2=null;
		try {
			d2= formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String testName=request.getParameter("testName");
		System.out.println(testName);
		String doctorId=request.getSession().getAttribute("doctorId").toString();
		System.out.println(doctorId);
		String patientId=request.getParameter("patientId");
		System.out.println(patientId);
		String doctorNote =request.getParameter("doctorNote");
		System.out.println(doctorNote);
		boolean insertStatus=helper.createPrescriptionDetails(0,d2,testName,Integer.parseInt(doctorId),Integer.parseInt(patientId),doctorNote);
		 System.out.println(insertStatus);
		if(insertStatus==true){
			String Message=null;
			request.setAttribute("patientId", patientId);
		request.getRequestDispatcher("PrescriptionSent.jsp").forward(request,response);
		 
		}				
		
	}else if (action.equals("PrescriptionList")){
		String doctorId=request.getSession().getAttribute("doctorId").toString();
		String patientId=request.getParameter("patientId");
	  List pList=(List)helper.getPrescriptionList(Integer.parseInt(doctorId),Integer.parseInt(patientId));
		request.setAttribute("pList",pList);
		request.getRequestDispatcher("ViewTestForm.jsp").forward(request,response);
		
	}else if(action.equals("PrescriptionForms")){
		
		int testId=Integer.parseInt(request.getParameter("testId"));
		Test fullForm =helper.getFullPrescription(testId); 
		request.setAttribute("fullForm",fullForm);
		request.getRequestDispatcher("ViewPrescription.jsp").forward(request, response);
		
	}else if(action.equals("resultForm")){
		String doctorId=request.getSession().getAttribute("doctorId").toString();
	    String patientId=request.getParameter("patientId");
		request.setAttribute("patientId",patientId);
		request.getRequestDispatcher("TestResultForm.jsp").forward(request, response);;
		
	}else if(action.equals("resultsFormDetails")){
		String doctorId=request.getSession().getAttribute("doctorId").toString();
		String patientId=request.getParameter("patientId");
		int testId=Integer.parseInt(request.getParameter("testId"));
		String date=request.getParameter("date");
		System.out.println(date);
		
		SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d2=null;
		try {
			d2= formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String normalRange=request.getParameter("normalRange");
		String actualResult=request.getParameter("actualResult");
		String testResultsNote=request.getParameter("testResultsNote");
		boolean insertResult=helper.createResultDetails(0,testId,d2,normalRange,actualResult,testResultsNote);
		if(insertResult==true){
			String Message=null;
			
			request.setAttribute("patientId", patientId);
		request.getRequestDispatcher("ResultSent.jsp").forward(request,response);
		 
		}	
		
	}else if(action.equals("viewResults")){
		String select=request.getSession().getAttribute("select").toString();
		String doctorId=null;
		String patientId=null;
		if(select.equals("Patient")){
			patientId=request.getSession().getAttribute("patientId").toString();
			doctorId=request.getParameter("doctorId");
			 request.setAttribute("doctorId",doctorId);
			}else{
			 doctorId=request.getSession().getAttribute("doctorId").toString();	
	         patientId=request.getParameter("patientId");
	         request.setAttribute("patientId",patientId);
			}
		int testId=Integer.parseInt(request.getParameter("testId"));
		TestResult r=helper.viewResult(testId);
	    request.setAttribute("r",r);
	   request.getRequestDispatcher("ViewResults.jsp").forward(request, response);
		}
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
