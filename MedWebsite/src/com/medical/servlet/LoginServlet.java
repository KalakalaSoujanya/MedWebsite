package com.medical.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username=request.getParameter("username");
		 	String password=request.getParameter("Password");
			String select=request.getParameter("select");
			LoginHelper lh= new LoginHelper();
			String message= lh.login(username, password ,select);
			System.out.println("***** success");
		    System.out.println(message);
		    RequestDispatcher rd=null;
		    request.getSession().setAttribute("username",username);
			if(select.equals("Patient")&&message.equals("success")){
				
				rd=request.getRequestDispatcher("PatientDashboard.jsp");
				PatientHelper helper= new PatientHelper();
				int patientId=helper.getPatientByuserName(username);
				 request.getSession().setAttribute("patientId",patientId);
				 request.getSession().setAttribute("select", select);
				}
			else if(select.equals("Doctor")&&message.equals("success")){
					rd=request.getRequestDispatcher("Doctordashboard.jsp");
					DoctorHelper helper= new DoctorHelper();
					int doctorId=helper.getDoctorByuserName(username);
					request.getSession().setAttribute("doctorId", doctorId);
					request.getSession().setAttribute("select", select);
					
			}
			else {
				
				request.setAttribute("error","LoginFailed");
				rd=request.getRequestDispatcher("MedLogin.jsp");
				
				
			}rd.forward(request,response);
			
			System.out.println("* success");
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
