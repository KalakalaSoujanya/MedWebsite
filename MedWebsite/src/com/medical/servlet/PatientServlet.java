package com.medical.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medical.servlet.Patient;
import com.medical.servlet.PatientHelper;
import com.medical.servlet.ShowScheduleList;

/**
 * Servlet implementation class PatientServlet
 */
@WebServlet("/Patient")
public class PatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd=null;
			
			PatientHelper helper= new PatientHelper();
			String action= request.getParameter("action");
			if(action.equals("create")){
				request.getSession().setAttribute("patientId", "patientId");
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			String emailId=request.getParameter("emailId");
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			Patient p= new Patient(firstName,lastName,emailId,userName,password);
			boolean status=helper.createPatient(p);
			
			if(status){
				request.getRequestDispatcher("MedLogin.jsp").forward(request, response);
			}
			
		}else if(action.equals("sendRequest")){
				String doctorId=request.getParameter("doctorId");
				String patientId=request.getSession().getAttribute("patientId").toString();
				if(!helper.requestSent(doctorId,patientId)){
					
					boolean status=helper.sendRequest(patientId, doctorId);
				   	System.out.println(status);
				   	   request.setAttribute("message", "Request sent successfully");
				   
				   	  }else{
				   		request.setAttribute("message", "Request already sent to the Doctor");
				   	  } 
				request.getRequestDispatcher("Doctor?action=search").forward(request,response);
			}else if(action.equals("doctorDecision")){
				
				String doctorId=request.getSession().getAttribute("doctorId").toString();
				List patientReqList=(List)helper.requestList(doctorId);
				request.setAttribute("patientReqList",patientReqList);
				request.getRequestDispatcher("PatientRequest.jsp").forward(request, response);
			
			}else if(action.equals("myDoctorList")){
				String patientId=request.getSession().getAttribute("patientId").toString();
				List myDoctorsList=(List)helper.myDoctorsList(patientId);
				request.setAttribute("myDoctorsList", myDoctorsList);
				request.getRequestDispatcher("MyDoctorList.jsp").forward(request, response);
			
			}else if(action.equals("appointmentPage")){
				String doctorId=request.getParameter("doctorId");
				String patientId=request.getSession().getAttribute("patientId").toString();
				request.getRequestDispatcher("Appointment.jsp").forward(request, response);
				
				
			}else if(action.equals("slotList")){
				String doctorId=request.getParameter("doctorId");
				String patientId=request.getSession().getAttribute("patientId").toString();
				String date=request.getParameter("date");
				System.out.println(date);
				DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
				Date d1=null;
				try {
					d1 = formatter.parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Date d2=new java.sql.Date(d1.getTime());
				AppointmentSlots appSlots=new AppointmentSlots();
				
				List<String> fullSlots=appSlots.slotList();
				
				
				
				List<String> filledSlots=new ArrayList<String>();
				
				System.out.println(fullSlots);
				
				List<Integer> list=helper.getFilledSlots(d2,Integer.parseInt(doctorId));
				for(Integer i:list){
					filledSlots.add(fullSlots.get(i-1));
				}
				System.out.println(list);
				System.out.println(filledSlots);
				
		fullSlots.removeAll(filledSlots);
				 
				 System.out.println(fullSlots);
				 
				 request.setAttribute("date", date);
				 request.setAttribute("fullSlots",fullSlots);
				 System.out.println(fullSlots);
				 request.getRequestDispatcher("AvailabilityList.jsp").forward(request, response);
				
			}else if(action.equals("bookingSlots")){
				String doctorId=request.getParameter("doctorId").toString();
				String patientId=request.getSession().getAttribute("patientId").toString();
				String slotNo=request.getParameter("slotNo");
				System.out.println(slotNo);
				AppointmentSlots appSlots=new AppointmentSlots();
				int slot=0;
				List<String> fullSlots=appSlots.slotList();
			slot=fullSlots.indexOf(slotNo)+1;
				
			     System.out.println(fullSlots);
				System.out.println(slot);
				
				String date1=request.getParameter("date");
				System.out.println(date1);
				DateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
				Date d1=null;
				try {
					d1 = formatter.parse(date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 boolean status=helper.bookingSlots(d1,slot,Integer.parseInt(doctorId),Integer.parseInt(patientId)); 
				 System.out.println(status);
				 request.setAttribute("doctorId",doctorId);
				 request.getRequestDispatcher("AppointmentConfirmation.jsp").forward(request, response);;
								
			}else if(action.equals("scheduledList")){
				String select= request.getSession().getAttribute("select").toString();
				String patientId=null;
				String doctorId=null;
				List<ScheduledAppointment> scheduledList=null;
			
				 if(select.equals("Patient")){
					 patientId=request.getSession().getAttribute("patientId").toString();
				     scheduledList=helper.patScheduledSlots(Integer.parseInt(patientId));
				 }else{
					 doctorId=request.getSession().getAttribute("doctorId").toString(); 
				 scheduledList=helper.docScheduledSlots(Integer.parseInt(doctorId));
				 
					 }
				 
				request.setAttribute("scheduledList",scheduledList);
				request.getRequestDispatcher("Scheduled.jsp").forward(request, response);
					
				}else if(action.equals("testResultsList")){
					String patientId=request.getSession().getAttribute("patientId").toString();
					String doctorId=request.getParameter("doctorId");
					List tList= helper.getTestResultsList(Integer.parseInt(patientId),Integer.parseInt(doctorId));
					request.setAttribute("tList",tList );
					request.setAttribute("doctorId", doctorId);
					request.getRequestDispatcher("PatientTestForm.jsp").forward(request, response);
					
					
				}else if (action.equals("logout")){
			request.getSession().invalidate();
			request.getRequestDispatcher("MedHome.jsp").forward(request, response);
					
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
